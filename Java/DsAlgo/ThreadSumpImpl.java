class ThreadSum implements Runnable {
	int a;
	int b;

	ThreadSum(int xa, int xb) {
		a = xa;
		b = xb;
	}

	public void run() {
		add(a, b);
	}

	public void add(int a, int b) {
		int sum = 0;
		// synchronized(this) {
		for (int i = a; i < b; i++) {
			sum += i;
		}
		System.out.println(sum);
		// }
	}
}

public class ThreadSumpImpl {
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadSum(1, 10));
		Thread t2 = new Thread(new ThreadSum(10, 20));
		t1.start();
		t2.start();

	}
}
