import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Find the next greater number using given set of digits

 two numbers are equal when all their digits are same in respective positions. The smallest number greater than a number n must have at least one digit greater than its respective position and all the positions right to this position must contain the smallest digits possible. 
 
 Question is how to get the next higher digit? We can simply sort the digit array and use binary search to get the floor (smallest number greater than or equal to key) from the array. However there is a special case when all the digits in the given number is contained in the digit. In this case we will end up in generating the input number itself as the next greater number (why?). How to solve this issue? If we do not find a higher digit in the whole scan then we need to replace the LSB of the number by the smallest digit that is strictly higher than the current digit at that position
 */
class NextGreaterImpl{
 public static int [] nextHigherWithDigits(int [] digits , int n){
	int [] sortedDigits = Arrays.copyOf(digits, digits.length);
	Arrays.sort(sortedDigits);
	ArrayList<Integer>nums = new ArrayList<Integer>();
	while(n>0) {
		nums.add(n%10);
		n /=10;
		
	}
	Collections.reverse(nums);
	boolean higherAdded = false;
	int [] res = new int[nums.size()];
	int i =0;
	for(int num: nums) {
		if(higherAdded) {
			res[i++] = sortedDigits[0];
			continue;
		}
		int nextHigher = binSearchCeiling(sortedDigits, 0, sortedDigits.length-1, num);
		if(nextHigher==-1) {
			return null;
		}
		else if(sortedDigits[nextHigher] > num){
			higherAdded = true;
		}
		
		res[i++] = sortedDigits[nextHigher];
	}
	
	if(!higherAdded){
		int nextHigher = binSearchCeiling(sortedDigits, 0, sortedDigits.length-1, res[i-1]+1);
		if(nextHigher == -1){
			return null;
		}
		
		res[i-1] = sortedDigits[nextHigher];
	}
	
	return res;
}
 
 public static int binSearchCeiling(int A[], int l, int h, int key){
		int mid = (l+h)/2;
		
		if(A[l] >= key){
			return l;
		}
		if(A[h] < key ){
			return -1;
		}
		
		if(A[mid] == key){
			return mid;
		}
		else if(A[mid] > key){
			if(mid-1 >= l && A[mid-1] <= key){
				return mid;
			}
			else{
				return binSearchCeiling(A, l, mid-1, key);
			}
		}
		else{
			if(mid + 1 <= h && A[mid+1] >= key){
				return mid+1;
			}
			else{
				return binSearchCeiling(A, mid+1, h, key);
			}
		}
	}
	
 }



public class NextGreaterNumberApp {

}
