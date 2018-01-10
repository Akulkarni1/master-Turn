package Time;

public class FunctProgApp {
	public static final int add(int a, int b) {

		return a + b;
	}

	public static final int mult(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) {
		System.out.print(add(mult(3, 3), mult(5, 2)));
	}
}
