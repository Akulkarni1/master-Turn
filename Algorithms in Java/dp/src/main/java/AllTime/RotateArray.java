package AllTime;

import java.util.Collections;
import java.util.List;

public class RotateArray {

    // Rotate Array
//algorithm1
    public static void rotateArray(int rotateAmount, List<Integer> list) {
        rotateAmount %= list.size();
        if (rotateAmount == 0) {
            return;
        }
        int numCycles = (int) gcd(list.size(), rotateAmount);
        int cycleLength = list.size() / numCycles;
        for (int i = 0; i < numCycles; i++) {
            applyCyclicPermutation(rotateAmount, i, cycleLength, list);
        }
    }

    private static void applyCyclicPermutation(int rotateAmount, int offset, int cycleLength, List<Integer> list) {
        int temp = list.get(offset);
        for (int i = 1; i < cycleLength; i++) {
            int val = list.get((offset + i * rotateAmount) % list.size());
            list.set((offset + i * rotateAmount) % list.size(), temp);
            temp = val;
        }
        list.set(offset, temp);
    }

    //GCD
    private static long gcd(long x, long y) {
        if (x == y) {
            return x;
        } else if ((x & 1) == 0 && (y & 1) == 0) {
            return gcd(x >>> 1, y >>> 1) << 1;
        } else if ((x & 1) == 0 && (y & 1) != 0) {
            return gcd(x >>> 1, y);
        } else if ((x & 1) != 0 && (y & 1) == 0) {
            return gcd(x, y >>> 1);
        } else if (x > y) {
            return gcd(x - y, y);
        }
        return gcd(x, y - x);
    }
//Another algorithm2

    public static void rotateArray2(int rotateAmount, List<Integer> list) {
        rotateAmount %= list.size();
        reverse(0, list.size(), list);
        reverse(0, rotateAmount, list);
        reverse(rotateAmount, list.size(), list);
    }

    public static void reverse(int begin, int end, List<Integer> list) {
        for (int i = begin, j = end - 1; i < j; ++i, --j) {
            Collections.swap(list, i, j);
        }
    }
}
