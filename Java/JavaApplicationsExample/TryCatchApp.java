
public class TryCatchApp {
	public static void main(String [] args) {
		int [] a = new int[10];
		try {
			a[9] = 20;
			int b=0;
			System.out.println(b);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
