
class DeadLockImpl {
	String str1 = "Hello";
	String str2 = "World";

	Thread th1 = new Thread("Thread1") {
		public void run() {
			while (true) {
				synchronized (str1) {
					synchronized (str2) {
						System.out.print("I am in Thread1");
						System.out.println(str1 + "" + str2);
					}
				}
			}
		}
	};

	Thread th2 = new Thread("Thread2") {
		public void run() {
			while (true) {
				synchronized (str2) {
					synchronized (str1) {
						System.out.println("I am in Thread2");
						System.out.println(str2 + "" + str1);
					}
				}
			}
		}
	};

}

public class DeadLockApp {
	public static void main(String[] args) {
		DeadLockImpl t = new DeadLockImpl();
		t.th1.start();
		t.th2.start();
	}
}
