package ProjectEuler;

import java.util.ArrayList;

class Multiple3and5Impl{
	int range;
	public ArrayList<Integer> getNumber(int range){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i =0;i<range;i++) {
			if(i%3==0||i%5==0) {
				result.add(i);
			}
		}
		return result;
	}
}
public class Multiple3and5App {
	public static void main(String[] args) {
		System.out.println(new Multiple3and5Impl().getNumber(10));
	}
}
