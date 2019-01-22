package Algorithm;

public class CountBits {
	public static int countBit(int n) {
		int count=0;
		while(n!=0) {
			count+=n&1;
			n >>= 1;
		}
		return count;
	}
	public static int flippedCount(int a, int b) {
		return countBit(a^b);
		
	}
	public static void main(String[] args) {
		int a=31;
		int b= 14;
		System.out.println(flippedCount(a,b));
		
	}
}