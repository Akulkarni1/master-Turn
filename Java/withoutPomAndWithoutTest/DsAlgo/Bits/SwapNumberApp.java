package Algorithm;

public class SwapNumberApp {
	public static void main(String[] args) {
		int a=50;
		int b=100;
		a= a^b;
		b= a^b;
		a = a^b;
		
		System.out.println(a+" "+b);
		
		System.out.println(numberSame(50,150));
	}
	public static boolean numberSame(int a,int b) {
		

	    if ((a ^ b) != 0)  
	    return false;  
	    else 
	        return true; 
	}
}
