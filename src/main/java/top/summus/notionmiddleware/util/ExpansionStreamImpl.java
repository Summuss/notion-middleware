package top.summus.notionmiddleware.util;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ExpansionStreamImpl<T> implements ExpansionStream<T> {
  private final Stream<T> stream;

   ExpansionStreamImpl(Stream<T> stream) {
    this.stream = stream;
  }

  @Override
  public Stream<T> getOriginalStream() {
    return stream;
  }

  @Override
  public  <R> ExpansionStream<R> extendStream(Stream<R> stream) {
    return new ExpansionStreamImpl<>(stream);
  }

  @Override
  public <R> Many2OneJoiner<T, R> many2OneJoin(Stream<R> stream) {
    return new Many2OneJoinerImpl<>(stream);
  }

  private class Many2OneJoinerImpl<R> implements Many2OneJoiner<T, R> {
    private final Stream<R> rightStream;

    public Many2OneJoinerImpl(Stream<R> rightStream) {
      this.rightStream = rightStream;
    }

    @Override
    public Many2OneJoinCondition<T, R> on(Function<T, ?> leftGetter, Function<R, ?> rightGetter) {
      return new Many2OneEqualJoinCondition(leftGetter, rightGetter);
    }

    @Override
    public Many2OneJoinCondition<T, R> on(BiPredicate<T, R> joinPredicate) {
      return new Many2OneCommonJoinCondition(joinPredicate);
    }

    private class Many2OneEqualJoinCondition extends BaseMany2OneJoinCondition {
      private final Function<T, ?> leftGetter;
      private final Function<R, ?> rightGetter;

      private Many2OneEqualJoinCondition(Function<T, ?> leftGetter, Function<R, ?> rightGetter) {
        this.leftGetter = leftGetter;
        this.rightGetter = rightGetter;
      }

      @Override
      public ExpansionStream<Pair<T, R>> asStream() {
        Map<?, R> map = getRightKeyValue();
        Stream<Pair<T, R>> pairStream =
            getOriginalStream()
                .map(
                    left -> {
                      Object leftKey = leftGetter.apply(left);
                      R right = map.get(leftKey);
                      return Pair.of(left, right);
                    });
        return extendStream(pairStream);
      }

      private Map<?, R> getRightKeyValue() {
        Map<?, R> map = null;
        if (binaryOperator == null) {
          map = rightStream.collect(Collectors.toMap(rightGetter, right -> right));
        } else {
          map = rightStream.collect(Collectors.toMap(rightGetter, right -> right, binaryOperator));
        }
        return map;
      }
    }

    private class Many2OneCommonJoinCondition extends BaseMany2OneJoinCondition {
      private final BiPredicate<T, R> joinPredicate;

      private Many2OneCommonJoinCondition(BiPredicate<T, R> joinPredicate) {
        this.joinPredicate = joinPredicate;
      }

      @Override
      public ExpansionStream<Pair<T, R>> asStream() {
        List<R> rightList = rightStream.collect(Collectors.toList());
        Stream<Pair<T, R>> stream =
            getOriginalStream()
                .map(
                    left -> {
                      Stream<R> rs =
                          rightList.stream()
                              .filter(innerRight -> joinPredicate.test(left, innerRight));
                      if (binaryOperator != null) {
                        R right = rs.reduce(binaryOperator).orElse(null);
                        return Pair.of(left, right);
                      } else {
                        Set<R> matchedSet = rs.collect(Collectors.toSet());
                        if (matchedSet.isEmpty()) {
                          return Pair.of(left, (R) null);
                        } else if (matchedSet.size() == 1) {
                          return Pair.of(left, matchedSet.stream().findAny().orElse(null));
                        } else {
                          throw new RuntimeException(
                              String.format("there are multiple matches for %s", left.toString()));
                        }
                      }
                    })
                .collect(Collectors.toList())
                .stream();
        return extendStream(stream);
      }
    }

    private abstract class BaseMany2OneJoinCondition implements Many2OneJoinCondition<T, R> {
      protected BinaryOperator<R> binaryOperator;

      @Override
      public Many2OneJoinCondition<T, R> whenConflict(BinaryOperator<R> binaryOperator) {
        this.binaryOperator = binaryOperator;
        return this;
      }
    }
  }
}
