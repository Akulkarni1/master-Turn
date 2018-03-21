import java.util.Arrays;

/*
 * Given a number N. Find the smallest even number greater than N such that the digits 
 * are a permutation of the number N.
 * 1. Find the largest index k such that nums[k] < nums[k + 1]. 
2. If no such index exists, the permutation is sorted in descending order, just reverse it to ascending order and we are done. For example, the next permutation of [3, 2, 1] is [1, 2, 3].
3. Find the largest index l greater than k such that nums[k] < nums[l].
4 Swap the value of nums[k] with that of nums[l].
5. Reverse the sequence from nums[k + 1] up to and including the final element nums[nums.size() - 1].

 */

public class NextEvenPermuApp {

	public  void swap(final int[] a, final int i, final int j) {
	    if (i == j || i < 0 || j < 0 || i > a.length - 1 || j > a.length - 1) {
	        return;
	    }
	    a[i] ^= a[j];
	    a[j] ^= a[i];
	    a[i] ^= a[j];
	}
	public  int[] nextEven(final int[] digits) {
	    int y = digits.length - 1;
	    boolean evenFound = digits[y] % 2 == 0;
	    for (int i = digits.length - 2; i >= 0; i--) {
	        if (digits[i] >= digits[i + 1]) {
	            evenFound |= digits[i] % 2 == 0;
	            y = i;
	        } else {
	            break;
	        }
	    }
	    int maxEven = -1;
	    // if y doesn’t contain an even then extend y to left until an even found
	    while (!evenFound && y - 1 >= 0 && digits[y - 1] % 2 != 0) {
	        y--;
	    }

	    // input is already the largest permutation
	    if (y <= 0) {
	        return digits[digits.length - 1] % 2 == 0 ? digits : null;
	    }
	    while(y -1 >= 0){
		    // now X = digits[0..y-1], and Y = digits[y..digits.length-1]
		    // a is the rightmost element of x, i.e. a = y-1;
		    // find b = min of y greater than a
		    final int a = y - 1;
		    int b = -1;
		    for (int i = y; i < digits.length; i++) {
		        b = digits[i] > digits[a] && (b == -1 || (digits[i] < digits[b])) ? i : b;
		    }

		    // input is already the largest permutation
		    if (b == -1) {
		        return digits[digits.length - 1] % 2 == 0 ? digits : null;
		    }
		    // swap a and b
		    swap(digits, a, b);

		    // update max even in y
		    for (int i = y; i < digits.length; i++) {
		        maxEven = digits[i] % 2 == 0 && (maxEven == -1 || (maxEven != -1 && digits[i] > digits[maxEven])) ? i
		                : maxEven;
		    }

		    // input is already the largest permutation or need to extend y
		    if (maxEven == -1) {
		    	y--;
		    }
		    else{
		    	break;
		    }
	    }
		    
	    if (maxEven == -1) {
	        return digits[digits.length - 1] % 2 == 0 ? digits : null;
	    }

	    // swap max even with rightmost position
	    swap(digits, maxEven, digits.length - 1);
	    // sort y leaving rightmost position unchanged
	    Arrays.sort(digits, y, digits.length - 1);

	    return digits;
	}
}
