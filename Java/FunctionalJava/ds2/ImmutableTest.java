package ds2;

import static org.junit.jupiter.api.Assertions.*;
import functions.Function1;
import functions.Function2;
import static ds2.ImmutableList.list;
import org.junit.jupiter.api.Test;

class ImmutableTest {

	@Test
	public void testMap() throws Exception {
		ImmutableList<Integer> list = list(1, 2, 3);
		Function1<Integer, Integer> dbl = new Function1<Integer, Integer>() {
			@Override
			public Integer evaluate(final Function1<Integer, Integer> self, final Integer i1) {
				return i1 * 2;
			}
		};
		ImmutableList<Integer> doubledList = list.map(dbl);
		assertEquals(list(2, 4, 6), doubledList);

	}

	@Test
	public void testMap2() throws Exception {
		ImmutableList<String> list = list("foo", "bar", "baz", "boom");
		Function1<String, String> dbl = new Function1<String, String>() {
			@Override
			public String evaluate(final Function1<String, String> self, final String i1) {
				return " " + i1.length();
			}
		};
		ImmutableList<String> doubledList = list.map(dbl);
		// assertEquals(list(2, 4, 6), doubledList);
		System.out.println(doubledList);

	}

	@Test
	public void testMap3() throws Exception {
		ImmutableList<String> list = list("foo", "bar", "baz", "boom");
		Function1<String, String> dbl = new Function1<String, String>() {
			@Override
			public String evaluate(final Function1<String, String> self, final String i1) {
				return " " + i1.toUpperCase();
			}
		};
		ImmutableList<String> doubledList = list.map(dbl);
		// assertEquals(list(2, 4, 6), doubledList);
		System.out.println(doubledList);

	}

	@Test
	public void testFold() {
		Function2<String, String, String> concat = new Function2<String, String, String>() {
			@Override
			public String evaluate(final Function2<String, String, String> self, final String i1, final String i2) {
				return i1 + i2;
			}
		};

		ImmutableList<String> list = list("a", "b", "c");
		assertEquals("dabc", list.foldLeft(concat, "d"));
		assertEquals("abcd", list.foldLft(concat, "d"));

		ImmutableList<String> emptyList = list();
		assertEquals("d", emptyList.foldLeft(concat, "d"));
		assertEquals("d", emptyList.foldLft(concat, "d"));
	}

	@Test
	public void testFold2() {
		Function2<Integer, Integer, String> len = new Function2<Integer, Integer, String>() {
			@Override
			public Integer evaluate(final Function2<Integer, Integer, String> self, final Integer i1, final String i2) {
				return i1 + i2.length();
			}
		};

		ImmutableList<String> list = list("foo", "bar", "baz", "boom");
		int i = list.foldLeft(len, 0);
		System.out.println(i);
		// assertEquals("dabc", list.foldLeft(len, "d"));
		// assertEquals("abcd", list.foldRight(concat, "d"));

		// ImmutableList<String> emptyList = list();
		// assertEquals("d", emptyList.foldLeft(concat, "d"));
		// assertEquals("d", emptyList.foldRight(concat, "d"));
	}

	@Test
	public void testFilter() throws Exception {
		ImmutableList<Integer> list = list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Function1<Boolean, Integer> isEven = new Function1<Boolean, Integer>() {
			@Override
			public Boolean evaluate(final Function1<Boolean, Integer> self, final Integer i1) {
				return i1 % 2 == 0;
			}
		};

		assertEquals(list(2, 4, 6, 8, 10), list.filter(isEven));
	}

	@Test
	public void testReverse() {
		ImmutableList<Integer> list = list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(list.reverse());
		assertEquals(list.reverse(), list(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
	}
}
