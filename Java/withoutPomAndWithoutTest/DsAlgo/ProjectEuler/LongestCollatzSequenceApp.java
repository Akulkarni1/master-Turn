package ProjectEuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCollatzSequenceApp {
	public static void longestCollatz(int n) {
		Set<Integer>values = new HashSet<Integer>();
		while(n>1) {
			if(n%2==0) {
				n=n/2;
				values.add(n);
			}
			else {
				n = 3*n+1;
				values.add(n);
			}
		}
		System.out.println(values.size());
		values.removeAll(values);
	}
	public static void main(String[]args) {
		for(int i =3;i<10;i++) {
			longestCollatz(i);
		}
	}
}
