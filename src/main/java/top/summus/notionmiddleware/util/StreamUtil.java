package top.summus.notionmiddleware.util;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : liuzongyang
 *     <p>将两个流进行<b>多对一</b>或<b>多对一或零</b>的连接操作。类似Sql中的<code>LEFT JOIN</code>。
 */
public class StreamUtil {

  public static <T> ExpansionStream<T> extendSteam(Stream<T> stream) {
    return new ExpansionStreamImpl<>(stream);
  }

  public static <L, R> ExpansionStream.Many2OneJoiner<L, R> manyToOneJoin(
      Stream<L> leftStream,
      Stream<R> rightStream) {
    return extendSteam(leftStream).many2OneJoin(rightStream);
  }


  public static <L, R> BiPredicate<L, R> joinOnEqual(
      Function<L, ?> leftFieldGetter, Function<R, ?> rightFieldGetter) {
    return (l, r) -> leftFieldGetter.apply(l).equals(rightFieldGetter.apply(r));
  }

  public static <T> BinaryOperator<T> takeTheFormer() {
    return (t, t2) -> t;
  }

  public static <T> BinaryOperator<T> takeTheLatter() {
    return (t, t2) -> t2;
  }

  public static <T> Function<T, T> selfAsValue() {
    return t -> t;
  }

  public static <L, R> Predicate<Pair<L, R>> rightIsNonNull() {
    return pair -> pair.getRight() != null;
  }

  public static <L, M, R>
      Collector<Pair<Pair<L, M>, R>, List<Triple<L, M, R>>, List<Triple<L, M, R>>> toTripleList() {
    return new Collector<Pair<Pair<L, M>, R>, List<Triple<L, M, R>>, List<Triple<L, M, R>>>() {
      @Override
      public Supplier<List<Triple<L, M, R>>> supplier() {
        return ArrayList::new;
      }

      @Override
      public BiConsumer<List<Triple<L, M, R>>, Pair<Pair<L, M>, R>> accumulator() {
        return (triples, pair) -> {
          triples.add(
              Triple.of(pair.getLeft().getLeft(), pair.getLeft().getRight(), pair.getRight()));
        };
      }

      @Override
      public BinaryOperator<List<Triple<L, M, R>>> combiner() {
        return (triples, triples2) -> {
          triples.addAll(triples2);
          return triples;
        };
      }
      @Override
      public Function<List<Triple<L, M, R>>, List<Triple<L, M, R>>> finisher() {
        return triples -> triples;
      }
      @Override
      public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
      }
    };
  }

}
