package ProjectEuler;
import java.util.ArrayList;

class EvenFibo {
	public ArrayList<Integer> EvenFibo(int range) {
		int i1 = 1;
		int i2 = 2;
		ArrayList<Integer>result = new ArrayList<Integer>();
		result.add(2);
		int i3 =0;
		for(int i =0;i<range;i++) {
			i3 = i1+i2;
			i1= i2;
			i2 = i3;
			if(i3%2==0) {
				result.add(i3);
			}
		}
		return result;
	}
}

public class EvenFiboApp {
	public static void main(String []args) {
		System.out.println(new EvenFibo().EvenFibo(8));
	}
}
