import java.util.Arrays;

//problem 1402. Reducing Dishes
public class MaxSatisfaction {
   public int maxSatisfaction(int [] arr){
      Arrays.sort(arr);
      int res =0, total=0, n = arr.length;
      for(int i=n-1;i>=0 && arr[i]>-total;--i){
         total +=arr[i];
         res += total;
      }
      return res;
   }
}
