package Time;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CollectedItems implements Runnable {
	ArrayList<Integer> item;

	public void addItem() {
		item = new ArrayList<Integer>();
		item.add(1);
		item.add(2);
		item.add(3);
		item.add(4);
		item.add(5);

	}

	static int result = 0;

	@Override
	public void run() {

		// System.out.println(item.get(3));
		synchronized (this) {
			addItem();
			for (Integer i : item)
				result = result + i;
			System.out.println("I am result" + result);

		}

	}
}

class ExecutorImpl {
	public void toRun() {
		ExecutorService ex = Executors.newFixedThreadPool(1);

		// for(int i =0;i<5;i++) {
		Runnable w = new CollectedItems();
		ex.execute(w);
		// }
		ex.shutdown();
	}
}

class ConcurrentLinkedQueueImpl {

	ConcurrentLinkedQueue<Integer> concurrent = new ConcurrentLinkedQueue<Integer>();
}

class Producer implements Runnable {
	ConcurrentLinkedQueue<String> que;

	Producer(ConcurrentLinkedQueue<String> qu) {
		que = qu;
	}

	public void run() {
		System.out.println("Producer started");

		try {
			for (int i = 1; i < 10; i++) {
				que.add("String" + i);
				System.out.println("Added String " + i);
				Thread.currentThread().sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {
	ConcurrentLinkedQueue<String> queue;

	Consumer(ConcurrentLinkedQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		String str;
		System.out.println("Consumer Started");
		for (int x = 0; x < 10; x++) {
			while ((str = queue.poll()) != null) {
				System.out.println("Removed: " + str);
			}
			try {
				Thread.currentThread().sleep(500);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}

public class ExecutorApp {
	public static void main(String[] args) {
		ExecutorImpl t = new ExecutorImpl();
		t.toRun();

		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
	}
}
