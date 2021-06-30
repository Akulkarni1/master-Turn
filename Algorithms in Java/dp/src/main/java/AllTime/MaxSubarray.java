import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MaxSubarray {
   /*
   if the given array A is circular, which means the
first and last elements of the array are to be treated as being adjacent to each other, the
algorithm yields suboptimum solutions.
    */

   public static int maxSubarraySumlnCircular2(List<Integer> data) {
      return Math.max(findMaxSubarray(data), findCircularMaxSubarray(data));
   }

   private static int findCircularMaxSubarray(List<Integer> data) {
      List<Integer> maxBegin = new ArrayList<>();
      int sum = data.get(0);
      maxBegin.add(sum);
      for (int i = 1; i < data.size(); i++) {
         sum += data.get(i);
         maxBegin.add(Math.max(maxBegin.get(maxBegin.size() - 1), sum));
      }
      List<Integer> maxEnd = new ArrayList<>(Collections.nCopies(data.size(), 0));
      sum = 0;
      for (int i = data.size() - 2; i >= 0; --i) {
         sum += data.get(i + 1);
         maxEnd.set(i, Math.max(maxEnd.get(i + 1), sum));
      }

      int circularMax = 0;
      for (int i = 0; i < data.size(); ++i) {
         circularMax = Math.max(circularMax, maxBegin.get(i) + maxEnd.get(i));
      }
      return circularMax;
   }

   private static int findMaxSubarray(List<Integer> data) {
      int maxTill = 0, max = 0;
      for (Integer a : data) {
         maxTill = Math.max(a, a + maxTill);
         max = Math.max(max, maxTill);
      }
      return max;
   }

   private interface IntegerComparator {
      Integer compare(Integer ol, Integer o2);
   }

   private static class MaxComparator implements IntegerComparator {
      @Override
      public Integer compare(Integer ol, Integer o2) {
         return ol > o2 ? ol : o2;
      }
   }

   private static class MinComparator implements IntegerComparator {
      @Override
      public Integer compare(Integer ol, Integer o2) {
         return ol > o2 ? o2 : ol;
      }
   }

   public static int maxSubarraySumlnCircular(List<Integer> data) {
// Finds the max in non-circular case and circular case.
      int accumulate = 0;
      for (int a : data) {
         accumulate += a;
      }
      return Math.max(findOptimumSubarrayUsingComp(data, new MaxComparator()),
              accumulate - findOptimumSubarrayUsingComp(data, new MinComparator())
      );
   }

   private static int findOptimumSubarrayUsingComp(List<Integer> data,
                                                   IntegerComparator comp) {
      int till = 0, overall = 0;
      for (int a : data) {
         till = comp.compare(a, a + till);
         overall = comp.compare(overall, till);
      }
      return overall;
   }
}