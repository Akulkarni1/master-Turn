package Time;

class TempRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I am thread" + Thread.currentThread().getName());
		System.out.println();
		for (int i = 0; i < 4; i++) {
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println();
	}

}

public class JoinApp {
	public static void main(String[] args) {
		Thread t1 = new Thread(new TempRunnable(), "1");
		Thread t3 = new Thread(new TempRunnable(), "3");
		t1.start();
		t3.start();
		try {
			t1.join();
			// t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 
 * 
 * The join method allows one thread to wait for the completion of another.
 * 
 * If t1 is a Thread object whose thread is currently executing,
 * 
 * t1.join() : causes the current thread to pause execution until t1's thread
 * terminates.
 * 
 * If t2 is a Thread object whose thread is currently executing,
 * 
 * t2.join(); causes the current thread to pause execution until t2's thread
 * terminates.
 * 
 * join API is low level API, which has been introduced in earlier versions of
 * java. Lot of things have been changed over a period of time (especially with
 * jdk 1.5 release) on concurrency front.
 */
