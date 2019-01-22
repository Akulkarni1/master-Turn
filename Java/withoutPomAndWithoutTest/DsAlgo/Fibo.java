package Algorithm;

public class Fibo {
	
	public static int fibo(int n) {
		int n1=0,n2=1,n3=0;
		for(int i=2;i<=n;++i) {
			n3= n1+n2;
			n1=n2;
			n2= n3;
		}
		return n3;
	}
	public static int recFibo(int n) {
		if(n<=1) {
			return n;
		}
		return recFibo(n-1)+recFibo(n-2);
	}
	public static void main(String[] args) {
	System.out.println(fibo(9));
	System.out.println(recFibo(9));
	}
}
