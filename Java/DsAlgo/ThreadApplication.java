import java.util.*;

class HeavyWorkRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Doing heavy processing - START "+Thread.currentThread().getName());
        try {
        	if(Thread.interrupted()){  
    			System.out.println("code for interrupted thread");  
    			}  
    			else{  
    			System.out.println("code for normal thread");  
    			}  
            Thread.sleep(1000);
            //Get database connection, delete unused data from DB
            System.out.println("I am in start");
            doDBProcessing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Doing heavy processing - END "+Thread.currentThread().getName());
    }

    private void doDBProcessing() throws InterruptedException {
        System.out.println("I am in DB processing");
    	Thread.sleep(5000);
    }

}
class HelloThread extends Thread{
	public void run() {
		System.out.println(" I am extend in Run by the thread "+Thread.currentThread().getName());
		try{
			Thread.sleep(1000);
			doDBProcessing();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("I am done with DB processing.");
		}
	}
	public void doDBProcessing() throws InterruptedException{
		System.out.println("I am in DBProcessing");
		
		Thread.sleep(1000);
	}
}
public class ThreadApplication {
	public static void main(String[] args) {
		//  ((Object) new Thread(new ThreadRunnable())).start();
		Thread t =new Thread(new HeavyWorkRunnable());
		t.start();
		Thread t1 = new Thread(new HeavyWorkRunnable());
		t1.start();
		t.interrupt();
		Thread t2 = new Thread(new HeavyWorkRunnable());
		t2.start();
		try {
		t2.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//new HelloThread().start();
	}
}