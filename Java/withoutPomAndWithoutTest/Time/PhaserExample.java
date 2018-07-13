package Time;

import java.util.concurrent.Phaser;

/*Phaser : A reusable synchronization barrier , similar functionality to that of cyclic barrier and countDownLatch , But 
 * supporting more flexible usage.
 * 
 */
public class PhaserExample {
	public static void main(String[] args) {

		Phaser phaser = new Phaser();

		Thread t1 = new MyThre(phaser, 1000);
		Thread t2 = new MyThre(phaser, 3000);
		Thread t3 = new MyThre(phaser, 10000);
		t1.start();
		t2.start();
		t3.start();

	}

}

class MyThre extends Thread {
	Phaser phaser;
	int sleep;

	MyThre(Phaser ph, int sleep) {
		phaser = ph;
		this.sleep = sleep;
	}

	public void run() {
		phaser.register();
		System.out.println(this.getName() + " begin");
		try {
			Thread.sleep(sleep);
		} catch (Exception e) {
		}
		phaser.arriveAndAwaitAdvance();
		System.out.println(this.getName() + " middle");
		try {
			Thread.sleep(sleep);
		} catch (Exception e) {
		}
		System.out.println(this.getName() + " end");
	}

}