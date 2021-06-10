import java.util.HashMap;
import java.util.Map;

public class PaligdromeParition {
   public static void main(String[] args) {
      System.out.println(palindromePartition("abc", 2));
   }

   private static int palindromePartition(String s, int k) {
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
         s.substring(i, k);
         if (isPalingdrome(s.substring(i, k))) {
            count++;
         }
      }
      return count;
   }

   private static boolean isPalingdrome(String substring) {
      for (int i = 0; i < substring.length(); i++) {
         for (int j = substring.length(); j >= 0; j--) {
            if (substring.charAt(i) == substring.charAt(j)) {
               return true;
            }
         }
      }
      return false;
   }
   Map<String,Integer> map = new HashMap<>();
   public int palingdromeParti(String s, int k){
      if(s.length()==k) return 0;
      int length = s.length();
      int [][]dp= new int[k][length+1];
      for(int i=0;i<length;i++){
         dp[0][i+1]= helper(s.substring(0,i+1));
      }
      for(int i=1;i<k;i++){
         for(int j=i;j<=length;j++){
            int cur = Integer.MAX_VALUE;
            for(int p=j;p>=i;p--){
               cur = Math.min(cur,dp[i-1][p-1]+helper(s.substring(p-1,j)));
            }
            dp[i][j]= cur;
         }
      }
      return dp[k-1][length];
   }

   private int helper(String str) {
      if (str == null || str.length() == 0) return 0;
      if (map.containsKey(str)) return map.get(str);
      int res = 0;
      for (int i = 0; i < str.length(); ++i){
         if (str.charAt(i) != str.charAt(str.length() - i - 1)) res++;
      }
      res /= 2;
      map.put(str, res);
      return res;
   }


}