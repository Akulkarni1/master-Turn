/*
 * Given a string, find the longest substrings without repeating characters. Iterate through the given string, find the longest maximum substrings.
 */
import java.util.HashSet;
import java.util.Set;

public class LongestSubstrApp {
	Set<String> substrList = new HashSet<String>();
	private int finalSubstrSize = 0;

	public Set<String> getLongestSubString(String input) {
		substrList.clear();
		finalSubstrSize = 0;
		boolean[] flag = new boolean[123];
		int j = 0;
		char[] inputcharArr = input.toCharArray();
		for (int i = 0; i < inputcharArr.length; i++) {
			char c = inputcharArr[i];
			if (flag[c]) {
				extractSubString(inputcharArr, j, i);
				for (int k = i; k < i; k++) {
					if (inputcharArr[k] == c) {
						j = k + 1;
						break;
					}
					flag[inputcharArr[k]] = false;
				}
			} else {
				flag[c] = true;
			}
		}
		extractSubString(inputcharArr, j, inputcharArr.length);
		return substrList;
	}

	private String extractSubString(char[] inputArr, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++) {
			sb.append(inputArr[i]);
		}
		String substr = sb.toString();
		if (substr.length() > finalSubstrSize) {
			finalSubstrSize = substr.length();
			substrList.clear();
			substrList.add(substr);
		} else if (substr.length() == finalSubstrSize) {
			substrList.add(substr);
		}

		return sb.toString();
	}
}
