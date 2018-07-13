package Time;

import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockOwnerExample {
	public static void main(String[] args) throws InterruptedException {
		MyRentrantLock lock1 = new MyRentrantLock();
		MyRentrantLock lock2 = new MyRentrantLock();
		MyThrd t1 = new MyThrd(lock1, lock2);
		MyThrd t2 = new MyThrd(lock1, lock2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}
}

class MyThrd extends Thread {
	MyRentrantLock lock1;
	MyRentrantLock lock2;

	MyThrd(MyRentrantLock lk1, MyRentrantLock lk2) {
		this.lock1 = lk1;
		this.lock2 = lk2;
	}

	public void run() {
		if (!lock1.tryLock()) {
			lock2.tryLock();
		}
		System.out.println(this.getName() + ": lock1 owner: " + lock1.Owner());
		System.out.println(this.getName() + ": lock2 owner: " + lock2.Owner());

	}
}

class MyRentrantLock extends ReentrantLock {
	String Owner() {
		Thread t = this.getOwner();
		if (t != null) {
			return t.getName();

		} else {
			return "none";
		}
	}

}