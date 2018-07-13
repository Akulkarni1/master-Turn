package Time;

class TempRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I am thread" + Thread.currentThread().getName());
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println();
	}

}

public class JoinApp {
	public static void main(String[] args) {
		Thread t1 = new Thread(new TempRunnable(), "1");
		Thread t2 = new Thread(new TempRunnable(), "2");
		Thread t3 = new Thread(new TempRunnable(), "3");
		t1.start();
		t3.start();
		try {
			t1.join(50000);
			 t3.join(50000);
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
 
 *class provides the join() method which allows one thread to wait until another thread completes its execution. 
 *If t is a Thread object whose thread is currently executing, then t.join(); it causes the current thread to pause 
 *its execution until thread it join completes its execution.
If there are multiple 
threads calling the join() methods that means overloading on join allows the programmer to specify a waiting period. However, as with sleep, join is dependent on the OS for timing, so you should not assume that join will wait exactly as long as you specify.
There are three overloaded join functions.

join(): It will put the current thread on wait until the thread on which it is called is dead. If thread is interrupted then it will throw InterruptedException.

 */

