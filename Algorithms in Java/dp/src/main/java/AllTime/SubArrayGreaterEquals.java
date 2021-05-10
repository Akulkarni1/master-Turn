package AllTime;

public class SubArrayGreaterEquals {
    /*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn’t one, return -1 instead.
For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2.
*/
    public static int minLenSubArraysum(int[] nums, int sum) {
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        int start = 0;
        int end = 0;
        while (start < nums.length) {
            if (currSum < sum && end < nums.length) {
                currSum += nums[end];
                end++;
            } else if (currSum >= sum) {
                minLen = Math.min(minLen, end - start);
                currSum -= nums[start];
                start++;
            } else {
                break;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }
}