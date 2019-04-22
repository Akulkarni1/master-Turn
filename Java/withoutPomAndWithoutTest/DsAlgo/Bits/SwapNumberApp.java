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
		
		System.out.println(Integer.toBinaryString(32));
		
		bitPattern(32);
	}
	public static boolean numberSame(int a,int b) {
		

	    if ((a ^ b) != 0)  
	    return false;  
	    else 
	        return true; 
	}
	static void bitPattern(int n) {

        int mask = 1 << 31;
        int count = 0;
        while(mask != 0) {
            if(count%4 == 0)
                System.out.print(" ");

            if((mask&n) == 0) 

                System.out.print("0");



            else 
                System.out.print("1");


            count++;
            mask = mask >>> 1;


    }
    System.out.println();
}
	
}
