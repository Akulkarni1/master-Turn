import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindAnagramApp {
	static int count = 0;
	static Set<String> set = new HashSet<String>();

	public static void main(String[] args) {
		String s = "abateatas";
		String pattern = "tea";
		for (int i = 0; i < s.length() - pattern.length(); i++) {
			AnagramCountAndPrint(s, pattern, i, i + pattern.length());

		}
	}

	public static void AnagramCountAndPrint(String str, String pattern, int starting, int ending) {

		int countArr = 0;
		String s = str.substring(starting, ending);
		/*
		 * for(int i= starting;i<ending;i++) { for(int j=0;j<pattern.length();j++) {
		 * if(str.charAt(i)==pattern.charAt(j)) if (countArr<pattern.length()) {
		 * countArr++; }
		 * 
		 * }
		 */
		permute(pattern, 0, pattern.length() - 1);
		if (set.contains(s))
			count++;

		System.out.println(count);

	}

	public static void permute(String str, int l, int r) {
		if (l == r) {
			// System.out.println(str);
			set.add(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swp(str, l, i);
				permute(str, l + 1, r);
				str = swp(str, l, i);
			}
		}

		/*
		 * int n = str.length(); if (n == 0) System.out.println(prefix); else { for (int
		 * i = 0; i < n; i++) permutation(prefix + str.charAt(i), str.substring(0, i) +
		 * str.substring(i+1, n)); }
		 */
	}

	public static String swp(String s, int l, int r) {
		char temp;
		char[] tempArr = s.toCharArray();
		temp = tempArr[l];
		tempArr[l] = tempArr[r];
		tempArr[r] = temp;
		return String.valueOf(tempArr);
	}

}
