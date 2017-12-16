package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/*Steps that will be follow are.
*Sort the input array.
*get the first element , minus the first element from the target.
*get the difference and find the difference in the sorted array with the help of binary search.
*If we get the element , we have the two elements else we will have have to move to second element.
and so on.
when we get the element we will print else we print message element not found.

*/
public class TwoSumApp {
	public static void main(String[] args) {
		int target = 10;
		int[] a = { 2, 4, 1, 5, 6, 7 };

	}

	public void sum(int[] a, int target) {
		HashMap<Integer, Integer> t = new HashMap<Integer, Integer>();
		Arrays.sort(a);
		int i = 0;
		while (i < a.length / 2) {
			int temp = target - a[i];
			if (binSearch(a, temp)) {
				int loc = getLocation(temp, a);
				t.put(a[i], a[loc]);
			}

		}
		System.out.println(t);
	}

	public boolean binSearch(int[] a, int temp) {
		return true;
	}

	public int getLocation(int temp, int[] a) {
		int loc = 0;
		return loc;
	}

}