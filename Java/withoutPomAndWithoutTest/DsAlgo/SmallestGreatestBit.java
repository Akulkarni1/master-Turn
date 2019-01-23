package Algorithm;

public class SmallestGreatestBit {
	public static void main(String[] args) {
		int x=8;
		System.out.println(getNext(x));
		System.out.println(getPrev(x));
	}
	static int getNext(int n) {
		int c=n;
		int c0=0;
		int c1=0;
		while((((c&1)==0)&&(c!=0))){
			c0++;
			c>>=1;
		}
		while((c&1)==1) {
			c1++;
			c>>=1;
		}
		if(c0+c1==31||c0+c1==0)
			return -1;
		int p= c0+c1;
		n|= (1<<p);
		n&=~((1<<p)-1);
		n|=(1<<(c1-1))-1;
		
		return n;
	}
	static int getPrev(int n) {
		int temp =n;
		int c0=0;
		int c1=0;
		while((temp&1)==1) {
			c1++;
			temp= temp>>1;
		}
		if(temp==0) {
			return -1;
		}
		while(((temp&1)==0)&&(temp!=0)) {
			c0++;
			temp = temp>>1;
		}
		return n-(1<<c1)-(1<<(c0-1))+1;
	}
}
