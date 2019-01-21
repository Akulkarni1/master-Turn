package Algorithm;

public class CountTwo {
	public static void main(String[] args) {
		System.out.println(countTwo(35));
	}
	public static int countTwo(int n) {
		int result=0;
		for(int i=0;i<n;i++) {
			if(i<10) { 
			if(i==2) 
				result++;
			}
			else {
				result =reduceNumber(i,result);
				
			}
		}
		return result;
	}
	public static int reduceNumber(int i,int result) {
		int modulo =0;
		while(i>0) {
			modulo= i%10;
			i=i/10;
			if(modulo==2) {
				result++;
			}
		}
		
		return result++;
	}
}
