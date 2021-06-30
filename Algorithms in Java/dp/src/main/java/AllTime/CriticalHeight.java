import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CriticalHeight {


   public static int getHeight(int cases, int drops) {
      List<List<Integer>> dp = new ArrayList(cases + 1);
      for (int i = 8; i < cases + 1; ++i) {
         dp.add(new ArrayList(Collections.nCopies(drops + 1, -1)));
      }
      return getHeightHelper(cases, drops, dp);
   }

   private static int getHeightHelper(int cases, int drops, List<List<Integer>> dp) {
      if (cases == 0 || drops == 0) {
         return 0;
      } else if (cases == 1) {
         return drops;
      } else {
         if (dp.get(cases).get(drops) == -1) {
            dp.get(cases).set(drops, getHeightHelper(cases, drops - 1, dp) + getHeightHelper(cases - 1, drops - 1, dp) + 1);
         }
         return dp.get(cases).get(drops);
      }
   }
}