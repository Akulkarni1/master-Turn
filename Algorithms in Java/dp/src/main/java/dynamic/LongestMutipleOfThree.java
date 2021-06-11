import java.util.Arrays;

public class LongestMutipleOfThree {
   public String largestMutipleOfThree(int[] digits){
      Arrays.sort(digits);
      int sum =0;
      int[] count =new int [10];
      for(int num:digits){
         sum+= num;
         count[num]++;
      }
      if(sum==0)
         return "0";
      if(sum%3==0)
         return solve(count, sum,0);
      if(sum%3==1)
         return solve(count,sum,1);
      if(sum%3==2)
         return solve(count,sum,2);
      return "";
   }

   private String solve(int[] count, int sum, int num) {
      if (num == 0) {
         return buildStr(count);
      }
      int mod = num;
      while (sum % 3 != 0) {
         if (count[mod]-- > 0) {
            sum -= mod;
         }
         if (mod % 3 == num || count[mod] <= 0) {
            mod += 3;
         }
         if (mod > 9) {
            mod = (mod + mod) % 3;
         }
      }
      return buildStr(count);
   }
   private String buildStr(int[] count) {
      StringBuilder sb = new StringBuilder();
      for (int i = 9; i >= 0; i--) {
         while (count[i]-- > 0) {
            sb.append(i);
         }
      }
      return sb.toString();
   }
}