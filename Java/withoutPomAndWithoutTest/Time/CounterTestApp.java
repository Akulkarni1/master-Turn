package Time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

class MyThread extends Thread {
	Counter counter;

	MyThread(Counter count) {
		counter = count;

	}

	public void run() {
		for (int x = 0; x < 1000; x++) {
			counter.incrementCount();
		}
	}
}

class Counter {
	private AtomicInteger count = new AtomicInteger(0);

	public void incrementCount() {
		count.incrementAndGet();
	}

	public int getCount() {
		return count.get();
	}
}

public class CounterTestApp {
	public static void main(String[] args) throws InterruptedException {
		final Counter count = new Counter();
		ArrayList<MyThread> threads = new ArrayList<MyThread>();
		for (int x = 0; x < 100; x++) {
			threads.add(new MyThread(count));
		}

		Iterator i1 = threads.iterator();
		while (i1.hasNext()) {
			MyThread my = (MyThread) i1.next();
			my.start();

		}
		Iterator i2 = threads.iterator();
		while (i2.hasNext()) {
			MyThread my = (MyThread) i2.next();
			my.join();

		}

	}
}
