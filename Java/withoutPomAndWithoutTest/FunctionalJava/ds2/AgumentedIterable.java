package ds2;

import functions.Function1;
import functions.Function2;

public interface AgumentedIterable<T> extends Iterable<T> {

	// Apply function f to each element in the collection (in order), collecting
	// the results in a new collection, which is returned.
	<R> AgumentedIterable<R> map(Function1<R, T> f);

	// Apply function f to the seed value and the first element in the
	// collection, then apply f to the result and the second element in
	// the collection, then apply f to that result and the third element in
	// the collection, etc. returning the final computed result.
	// If the collection is empty, then return the seed value.
	<R> R foldLeft(Function2<R, R, T> f, R seed);

	// Apply function f to the last element in the collection and the seed
	// value, then apply f to the second-last element and the previous result,
	// then apply f to the third-last element and that result, etc.
	// returning the final computed result.
	// If the collection is empty, then return the seed value.
	<R> R foldLft(Function2<R, T, R> f, R seed);// Right

	// Apply function f to each element in the collection (in order), and
	// collect the values returned from each f application, to be returned in
	// a new collection.
	// <R> AgumentedIterable<R> flatMap(Function1<? extends Iterable<R>, T> f);

	// Return the elements of the this collection (in their original order)
	// that return true for the given predicate.
	AgumentedIterable<T> filter(Function1<Boolean, T> predicate);
}