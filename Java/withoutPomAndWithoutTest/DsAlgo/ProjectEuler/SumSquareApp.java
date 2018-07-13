package ProjectEuler;
class SumSquareImpl{
	public void sumSquare() {
			int sumResult=0;
		for(int i =0;i<=10;i++) {
			sumResult += Math.pow(i, 2);
		}
		
		int sum=0;
		for(int i =0;i<=10;i++) {
			sum+=i;
		}
		int pow = (int) Math.pow(sum,2);
		System.out.println(pow- sumResult);
	}
}
public class SumSquareApp {
	public static void main(String[]args) {
		new SumSquareImpl().sumSquare();
	}

}
