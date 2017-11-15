import java.util.*;
class SynchCounter{
	int c=0;
	public synchronized void increment() {
		c++;
	}
	public synchronized void decrement() {
		c--;
	}
	public synchronized int value() {
		return c;
	}
}
class SynchImpl implements Runnable{
	SynchCounter c;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		c= new SynchCounter();
		c.increment();
		c.increment();
		System.out.println(c.value());
		c.decrement();
		c.decrement();
		System.out.println(c.value());
		
	}
	
}
class Deadlock{
	static class Friend{
		private final String name;
		public Friend(String string) {name = string;}
		public String getName() {
			return name;
		}
		 public synchronized void bow(Friend bower) {
	            System.out.format("%s: %s"
	                + "  has bowed to me!%n", 
	                this.name, bower.getName());
	            bower.bowBack(this);
	        }
		 public synchronized void bowBack(Friend bower) {
	            System.out.format("%s: %s"
	                + " has bowed back to me!%n",
	                this.name, bower.getName());
	        }
	}
}
public class SynchApp {
	public static void main(String[] args) {
		/*Thread t = new Thread(new SynchImpl());
		t.start();
		Thread t2 = new Thread(new SynchImpl());
		t2.start();
		Thread t3 = new Thread(new SynchImpl());
		t3.start();
		*/
		
		final Deadlock.Friend alphonse =
				new Deadlock.Friend("Alphonse");
		final Deadlock.Friend gaston =
				new Deadlock.Friend("Gaston");
	        new Thread(new Runnable() {
	            public void run() { alphonse.bow(gaston); }
	        }).start();
	        new Thread(new Runnable() {
	            public void run() { gaston.bow(alphonse); }
	        }).start();
	}
}
