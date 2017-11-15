package ProjectEuler;
class SmallestImpl{
	
	public long smallestMultiple(){
		long t= -1;
		boolean flag =true;
		for(long i=1;i<100000000;i++) {
			flag=true;
			if(i%2==0&&i%3==0&&i%4==0&&i%5==0&&i%6==0&&i%7==0&&i%8==0&&i%9==0&&i%10==0&&flag==true) {
				//System.out.println("Number is divisible 2");
				System.out.println("I="+i);
				t = i;
				flag =true;
				break;
			}
			else {flag =false;}
			
		
		}
		return t;
	}
}

public class SmallestMultipleApp {
	public static void main(String[] args) {
		System.out.println(new SmallestImpl().smallestMultiple());
	}
}
