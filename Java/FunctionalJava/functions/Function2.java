package functions;

public abstract class Function2<R, T1, T2> extends Curry<T1, Function1<R, T2>> {
	public abstract R evaluate(final Function2<R, T1, T2> self, final T1 i1, final T2 i2);

	public R evaluate(final T1 i1, final T2 i2) {
		return evaluate(this, i1, i2);
	}

	@Override
	public Function1<Function1<R, T2>, T1> curry() {
		return new Function1<Function1<R, T2>, T1>() {
			public Function1<R, T2> evaluate(Function1<Function1<R, T2>, T1> self, final T1 i1) {
				return new Function1<R, T2>() {
					@Override
					public R evaluate(Function1<R, T2> self, final T2 i2) {
						return Function2.this.evaluate(Function2.this, i1, i2);
					}
				};
			}
		};
	}

	@Override
	public Function1<R, T2> apply(final Function0<T1> t) {
		return new Function1<R, T2>() {
			@Override
			public R evaluate(final Function1<R, T2> self, final T2 i1) {
				return Function2.this.evaluate(t.get(), i1);
			}
		};
	}

	public final Function0<R> apply(final T1 i1, final T2 i2) {
		return apply(i1).apply(i2);
	}

	public final Function0<R> apply(final Function0<T1> i1, final Function0<T2> i2) {
		return apply(i1).apply(i2);
	}

	public Function2<R, T2, T1> flip() {
		return new Function2<R, T2, T1>() {
			public R evaluate(Function2<R, T2, T1> self, final T2 i1, final T1 i2) {
				return Function2.this.evaluate(Function2.this, i2, i1);
			}
		};
	}
}