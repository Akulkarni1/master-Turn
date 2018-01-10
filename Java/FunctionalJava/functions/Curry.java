package functions;

public abstract class Curry<T, F> {
	public abstract Function1<F, T> curry();

	public F apply(T t) {
		return curry().apply(t).get();
	}

	public abstract F apply(Function0<T> t);
}