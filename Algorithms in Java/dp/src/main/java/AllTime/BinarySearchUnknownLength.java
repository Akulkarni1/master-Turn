package AllTime;

import java.util.List;

public class BinarySearchUnknownLength {
    public int binarySearchUnknownLength(List<Integer> data, int k) {
        int p = 0;
        while (true) {
            try {
                int idx = (k << p) - 1;
                if (data.get(idx) == k) {
                    return idx;
                } else if (data.get(idx) > k) {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            ++p;
        }
        int left = Math.max(0, 1 << (p - 1)), right = (1 << p) - 2;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            try {
                if (data.get(mid) == k) {
                    return mid;
                } else if (data.get(mid) > k) {
                    right = mid - 1;
                } else { // A . get (mid) < k
                    left = mid + 1;
                }
            } catch (Exception e) {
                right = mid - 1; // Search the left part if out -of -bound .
            }
        }
        return -1;
    }
}