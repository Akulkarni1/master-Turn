import java.util.List;

public class PairSum {
   private static class IndexPair {
      public int index1;
      public int index2;

      public IndexPair(Integer indexl, Integer index2) {
         this.index1 = indexl;
         this.index2 = index2;
      }
   }

   private static interface BooleanCompare {
      public boolean compare(Integer indexl, Integer index2);
   }

   private static class CompareLess implements BooleanCompare {
      @Override
      public boolean compare(Integer ol, Integer o2) {
         return ol < o2;
      }

      public static final CompareLess LESS = new CompareLess();
   }

   private static class CompareGreaterEqual implements BooleanCompare {
      @Override
      public boolean compare(Integer ol, Integer o2) {
         return ol >= o2;
      }

      public static final CompareGreaterEqual GREATER_OR_EQUAL = new CompareGreaterEqual();
   }

   public static IndexPair findPairSumK(List<Integer> A, int k) {
      IndexPair result = findPosNegPair(A, k);
      if (result.index1 == -1 && result.index2 == -1) {
         return k >= 0
                 ? findPairUsingComp(A, k, CompareLess.LESS)
                 : findPairUsingComp(A, k, CompareGreaterEqual.GREATER_OR_EQUAL);
      }
      return result;
   }

   private static IndexPair findPairUsingComp(List<Integer> A, int k,
                                              BooleanCompare comp) {
      IndexPair result = new IndexPair(0, A.size() - 1);
      while (result.index1 < result.index2
              && comp.compare(A.get(result.index1), 0)) {
         result.index1 = result.index1 + 1;
      }
      while (result.index1 < result.index2
              && comp.compare(A.get(result.index2), 0)) {
         result.index2 = result.index2 - 1;
      }
      while (result.index1 < result.index2) {
         if (A.get(result.index1) + A.get(result.index2) == k) {
            return result;
         } else if (comp.compare(A.get(result.index1) + A.get(result.index2), k))
            do {
               result.index1 = result.index1 + 1;
            } while (result.index1 < result.index2
                    && comp.compare(A.get(result.index1), 0));
         else {
            do {
               result.index2 = result.index2 - 1;
            } while (result.index1 < result.index2
                    && comp.compare(A.get(result.index2), 0));
         }
      }
      return new IndexPair(-1, -1);
   }

   private static IndexPair findPosNegPair(List<Integer> A, int k) {
      IndexPair result = new IndexPair(A.size() - 1, A.size() - 1);
      while (result.index1 >= 0 && A.get(result.index1) < 0) {
         result.index1 = result.index1 - 1;
      }


      while (result.index2 >= 0 && A.get(result.index2) >= 0) {
         result.index2 = result.index2 - 1;
      }
      while (result.index1 >= 0 && result.index2 >= 0) {
         if (A.get(result.index1) + A.get(result.index2) == k) {
            return result;
         } else if (A.get(result.index1) + A.get(result.index2) > k) {
            do {
               result.index1 = result.index1 - 1;
            } while (result.index1 >= 0 && A.get(result.index1) < 0);
         } else {
            do {
               result.index2 = result.index2 - 1;
            } while (result.index2 >= 0 && A.get(result.index2) >= 0);
         }
      }
      return new IndexPair(-1, -1);
   }
}