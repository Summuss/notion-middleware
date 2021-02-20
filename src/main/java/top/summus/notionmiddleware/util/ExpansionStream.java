package top.summus.notionmiddleware.util;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface ExpansionStream<T> extends Stream<T> {

  Stream<T> getOriginalStream();

  <R> ExpansionStream<R> extendStream(Stream<R> stream);

  <R> Many2OneJoiner<T, R> many2OneJoin(Stream<R> stream);

  default List<T> toList() {
    return getOriginalStream().collect(Collectors.toList());
  }

  default Set<T> toSet() {
    return getOriginalStream().collect(Collectors.toSet());
  }

  default <K, V> Map<K, V> toMap(
      Function<? super T, ? extends K> var0, Function<? super T, ? extends V> var1) {
    return getOriginalStream().collect(Collectors.toMap(var0, var1));
  }

  default <K, V> Map<K, V> toMap(
      Function<? super T, ? extends K> var0,
      Function<? super T, ? extends V> var1,
      BinaryOperator<V> var2) {
    return getOriginalStream().collect(Collectors.toMap(var0, var1, var2));
  }

  default ExpansionStream<T> filter(Predicate<? super T> predicate) {
    return extendStream(getOriginalStream().filter(predicate));
  }

  default <R> ExpansionStream<R> map(Function<? super T, ? extends R> function) {
    return extendStream(getOriginalStream().map(function));
  }

  default IntStream mapToInt(ToIntFunction<? super T> toIntFunction) {
    return getOriginalStream().mapToInt(toIntFunction);
  }

  default LongStream mapToLong(ToLongFunction<? super T> toLongFunction) {
    return getOriginalStream().mapToLong(toLongFunction);
  }

  default DoubleStream mapToDouble(ToDoubleFunction<? super T> toDoubleFunction) {
    return getOriginalStream().mapToDouble(toDoubleFunction);
  }

  default <R> ExpansionStream<R> flatMap(
      Function<? super T, ? extends Stream<? extends R>> function) {
    return extendStream(getOriginalStream().flatMap(function));
  }

  default IntStream flatMapToInt(Function<? super T, ? extends IntStream> function) {
    return getOriginalStream().flatMapToInt(function);
  }

  default LongStream flatMapToLong(Function<? super T, ? extends LongStream> function) {
    return getOriginalStream().flatMapToLong(function);
  }

  default DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> function) {
    return getOriginalStream().flatMapToDouble(function);
  }

  default ExpansionStream<T> distinct() {
    return extendStream(getOriginalStream().distinct());
  }

  default ExpansionStream<T> sorted() {
    return extendStream(getOriginalStream().sorted());
  }

  default ExpansionStream<T> sorted(Comparator<? super T> comparator) {
    return extendStream(getOriginalStream().sorted(comparator));
  }

  default ExpansionStream<T> peek(Consumer<? super T> consumer) {
    return extendStream(getOriginalStream().peek(consumer));
  }

  default ExpansionStream<T> limit(long l) {
    return extendStream(getOriginalStream().limit(l));
  }

  default ExpansionStream<T> skip(long l) {
    return extendStream(getOriginalStream().skip(l));
  }

  default void forEach(Consumer<? super T> consumer) {
    getOriginalStream().forEach(consumer);
  }

  default void forEachOrdered(Consumer<? super T> consumer) {
    getOriginalStream().forEachOrdered(consumer);
  }

  default Object[] toArray() {
    return getOriginalStream().toArray();
  }

  default <A> A[] toArray(IntFunction<A[]> intFunction) {
    return getOriginalStream().toArray(intFunction);
  }

  default T reduce(T t, BinaryOperator<T> binaryOperator) {
    return getOriginalStream().reduce(t, binaryOperator);
  }

  default Optional<T> reduce(BinaryOperator<T> binaryOperator) {
    return getOriginalStream().reduce(binaryOperator);
  }

  default <U> U reduce(
      U u, BiFunction<U, ? super T, U> biFunction, BinaryOperator<U> binaryOperator) {
    return getOriginalStream().reduce(u, biFunction, binaryOperator);
  }

  default <R> R collect(
      Supplier<R> supplier, BiConsumer<R, ? super T> biConsumer, BiConsumer<R, R> biConsumer1) {
    return getOriginalStream().collect(supplier, biConsumer, biConsumer1);
  }

  default <R, A> R collect(Collector<? super T, A, R> collector) {
    return getOriginalStream().collect(collector);
  }

  default Optional<T> min(Comparator<? super T> comparator) {
    return getOriginalStream().min(comparator);
  }

  default Optional<T> max(Comparator<? super T> comparator) {
    return getOriginalStream().max(comparator);
  }

  default long count() {
    return getOriginalStream().count();
  }

  default boolean anyMatch(Predicate<? super T> predicate) {
    return getOriginalStream().anyMatch(predicate);
  }

  default boolean allMatch(Predicate<? super T> predicate) {
    return getOriginalStream().allMatch(predicate);
  }

  default boolean noneMatch(Predicate<? super T> predicate) {
    return getOriginalStream().noneMatch(predicate);
  }

  default Optional<T> findFirst() {
    return getOriginalStream().findFirst();
  }

  default Optional<T> findAny() {
    return getOriginalStream().findAny();
  }

  default Iterator<T> iterator() {
    return getOriginalStream().iterator();
  }

  default Spliterator<T> spliterator() {
    return getOriginalStream().spliterator();
  }

  default boolean isParallel() {
    return getOriginalStream().isParallel();
  }

  default ExpansionStream<T> sequential() {
    return extendStream(getOriginalStream().sequential());
  }

  default ExpansionStream<T> parallel() {
    return extendStream(getOriginalStream().parallel());
  }

  default ExpansionStream<T> unordered() {
    return extendStream(getOriginalStream().unordered());
  }

  default ExpansionStream<T> onClose(Runnable runnable) {
    return extendStream(getOriginalStream().onClose(runnable));
  }

  default void close() {
    getOriginalStream().close();
  }

  interface Joiner<L, R> {
    JoinCondition<L, R> on(Function<L, ?> leftGetter, Function<R, ?> rightGetter);
  }

  interface Many2OneJoiner<L, R> {
    Many2OneJoinCondition<L, R> on(Function<L, ?> leftGetter, Function<R, ?> rightGetter);

    Many2OneJoinCondition<L, R> on(BiPredicate<L, R> joinPredicate);
  }

  interface JoinCondition<L, R> {
    ExpansionStream<Pair<L, R>> asStream();
  }

  interface Many2OneJoinCondition<L, R> extends JoinCondition<L, R> {
    Many2OneJoinCondition<L, R> whenConflict(BinaryOperator<R> binaryOperator);
  }
}
