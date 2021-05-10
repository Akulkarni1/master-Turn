package AllTime;

import java.util.Collections;
import java.util.List;

public class FindPositiveEntry {

    /*
    find the missing +ve entry.
    Let A be an array of length n. Design an algorithm to find the smallest positive integer
    which is not present in A. You do not need to preserve the contents of A. For example,
    if A = (3, 5, 4, —1,5, 1,-1), the smallest positive integer not present in A is 2.
    */
    public static int findFirstMissingPositiveNumber(List<Integer> data) {
        int i = 0;
        while (i < data.size()) {
            if (data.get(i) > 0 && data.get(i) <= data.size() && data.get(data.get(i) - 1) != data.get(i)) {
                Collections.swap(data, i, data.get(i) - 1);
            } else {
                ++i;
            }
        }
        for (i = 0; i < data.size(); i++) {
            if (data.get(i) != i + 1) {
                return i + 1;
            }
        }
        return data.size() + 1;
    }
}