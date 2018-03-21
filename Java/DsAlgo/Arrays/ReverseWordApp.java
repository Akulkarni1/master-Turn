import java.util.LinkedList;
import java.util.Stack;

public class ReverseWordApp {
	public static String reverseWord(String str) {
		String words[] = str.split("\\s");
		String reverseWord = "";
		for (String w : words) {
			StringBuilder sb = new StringBuilder(w);
			sb.reverse();
			reverseWord += sb.toString() + " ";
		}
		return reverseWord.trim();
	}

	public static String reverseString(String toreverse) {
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < toreverse.length(); i++) {
			s.push(toreverse.charAt(i));
		}
		char[] temp = new char[s.size()];
		int count = 0;
		while (!s.empty()) {
			temp[count] = s.pop();
			count++;
		}
		String result = String.valueOf(temp);
		return result;
	}

	public static String reverse(String toreverse) {
		String tempResult = "";
		String result = "";
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < toreverse.length(); i++) {
			s.push(toreverse.charAt(i));
			if (toreverse.charAt(i) == ' ' || i == toreverse.length() - 1) {
				int count = 0;
				char[] temp = null;
				temp = new char[s.size()];
				while (!s.empty()) {

					temp[count] = s.pop();
					count++;
				}
				tempResult = String.valueOf(temp);
				result = result + tempResult;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String toreverse = "Hello World this is";
		String temp = reverseWord(toreverse);
		System.out.println(temp);
		System.out.println(reverseString(temp));
	}
}
