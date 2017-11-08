/*Guess the output
*/

class ThreadImpl implements Runnable
{
	private Thread t;
	private String threadName;
	ThreadImpl(String t){
		threadName=t;
	}
	public void run() {
		while(true) {
			System.out.println(threadName);
			
		}
	}
	public void start() {
		if(t==null) {
			t=new Thread(this,threadName);
			t.start();
		}
	}
}

public class ThreadApp {
	public static void main(String[] args) {
		ThreadImpl a = new ThreadImpl("A");
		ThreadImpl b= new ThreadImpl("B");
		b.start();
		a.start();
	}
}