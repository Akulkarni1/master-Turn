package AllTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindBiggestProduct {
    /*
Given an array A of length n whose entries are integers, compute the largest product
that can be made using n - 1 entries in A. You cannot use an entry more than once.
Array entries may be positive, negative, or 0. Your algorithm cannot use the division
operator, explicitly or implicitly.
*/

    public static int findBiggestProduct(List<Integer> list) {
        int product = 1;
        List<Integer> suffixProducts = new ArrayList<>(Collections.nCopies(list.size(), 0));
        for (int i = list.size() - 1; i >= 0; i--) {
            product *= list.get(i);
            suffixProducts.set(i, product);
        }
        int prefixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int suffixProduct = i + 1 < list.size() ? suffixProducts.get(i + 1) : 1;
            maxProduct = Math.max(maxProduct, prefixProduct * suffixProduct);
            prefixProduct *= list.get(i);
        }
        return maxProduct;
    }

//Another approoch if the entries are -ve

    public static int findBiggestProduct2(List<Integer> list) {
        int leastNonnegativeIdx = -1;
        int numberOfnegative = 0, greatestnegativeIdx = -1, leastnegativeIdx = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                ++numberOfnegative;
                if (leastnegativeIdx == -1 || list.get(leastnegativeIdx) < list.get(i)) {
                    leastnegativeIdx = i;
                }
                if (greatestnegativeIdx == -1 || list.get(i) < list.get(greatestnegativeIdx)) {
                    greatestnegativeIdx = i;
                }
            } else if (list.get(i) >= 0) {
                if (leastNonnegativeIdx == -1 || list.get(i) < list.get(leastNonnegativeIdx))
                    leastNonnegativeIdx = i;
            }
        }

        int product = 1;
        int idxToSkip = (numberOfnegative % 2) != 0 ? leastnegativeIdx : (leastNonnegativeIdx != -1 ? leastNonnegativeIdx : greatestnegativeIdx);
        for (int i = 0; i < list.size(); i++) {
            if (i != idxToSkip) {
                product *= list.get(i);
            }
        }
        return product;
    }
}