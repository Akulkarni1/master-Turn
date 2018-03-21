import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

/*
 * Given a dictionary and a word. Find all the anagrams of the given word in the
 * dictionary.
 */
class Dictionary {
	private Set<String> dict = new HashSet<String>();

	public void add(String word) {
		dict.add(word);
	}

	public void addAll(List<String> words) {
		dict.addAll(words);
	}

	public boolean remove(String word) {
		return dict.remove(word);
	}

	public String getKey(String str) {
		str = str.toLowerCase().trim();
		int[] hist = new int[256];
		for (int i = 0; i < str.length(); i++) {
			hist[str.charAt(i)]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int val : hist) {
			sb.append(val);
		}
		return sb.toString();
	}

	public int searchAnagram(String pattern) {
		int count = 0;
		HashMap<String, List<String>> histMap = new HashMap<String, List<String>>();

		for (String word : dict) {
			String key = getKey(word);
			if (!histMap.containsKey(key)) {
				histMap.put(key, new ArrayList<String>());
			}

			histMap.get(key).add(word);
		}

		String searchKey = getKey(pattern);
		List<String> res = histMap.get(searchKey);

		if (res != null) {
			count = res.size();

			System.out.print("anagrams in dict: ");
			for (String s : res) {
				System.out.print(s + " ");
			}
			System.out.println();
		}

		return count;
	}
}
