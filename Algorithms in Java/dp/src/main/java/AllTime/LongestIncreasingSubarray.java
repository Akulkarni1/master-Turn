package AllTime;

import java.util.List;

public class LongestIncreasingSubarray {
    /*
Implement an algorithm that takes as input an array A of n elements, and returns the
beginning and ending indices of a longest increasing subarray of A. For example, if
A = (2, 11, 3, 5, 13, 7, 19,17, 23), the longest increasing subarray is (3, 5, 13), and you
should return (2,4).
*/
    public static void main(String[] args) {
    }

    private static class Subarray {
        Integer start;
        Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public Subarray findLongestIncreasingSubarray(List<Integer> list) {
        int maxLength = 1;
        Subarray ans = new Subarray(0, 0);
        int i = 0;
        while (i < list.size() - maxLength) {
            boolean isSkippable = false;
            for (int j = i + maxLength; j > i; --j) {
                if (list.get(j - 1) >= list.get(j)) {
                    i = j;
                    isSkippable
                            =
                            true;
                    break;
                }
            }
            if (!isSkippable) {
                i += maxLength;
                while (i < list.size() && list.get(i - 1) < list.get(i)) {
                    ++i;
                    ++maxLength;
                }
                ans = new Subarray(i - maxLength, i - 1);
            }
        }
        return ans;
    }
}