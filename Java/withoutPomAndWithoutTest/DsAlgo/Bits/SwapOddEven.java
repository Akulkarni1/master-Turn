package Algorithm;

public class SwapOddEven {

	static int swapBits(int x) {
		int evenBits= x & 0xAAAAAAAA;
		
		int oddBits= x & 0x55555555;
		
		evenBits >>=1;
		
		oddBits <<=1;
		return evenBits|oddBits;
	}
	public static void main(String[] args) {
		int x=5823;
		System.out.println(swapBits(x));
	}
}
