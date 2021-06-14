import java.util.PriorityQueue;

public class MinimumFallingSumPath {
   //leetcode problem 1289

   public int minFallingPath(int[][]arr){
      for(int row = arr.length-2;row>=0;row--){
         for(int col=0;col<arr.length;col++){
            int min= Integer.MAX_VALUE;
            for(int k=0;k<col;k++){
               min = Math.min(arr[row+1][k],min);
            }
            for(int k=col+1;k<arr.length;k++){
               min = Math.min(arr[row+1][k], min);
            }
            arr[row][col]+= min;
         }
      }
      int result = Integer.MAX_VALUE;
      for(int i=0;i< arr.length;i++){
         result = Math.min(result,arr[0][i]);
      }
      return result;
   }
   public int minFallingPath2(int [][]arr){
      for(int rowIndex =1;rowIndex< arr.length;rowIndex++){
         PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
         for(int col =0;col<arr[0].length;col++){
            priorityQueue.offer(arr[rowIndex-1][col]);
         }
         int firstSmallest= priorityQueue.poll();
         int secSmallest = priorityQueue.poll();
         for(int col=0;col<arr[0].length;col++){
            if(arr[rowIndex-1][col]==firstSmallest){
               arr[rowIndex] [col] = arr[rowIndex] [col] + secSmallest;
            } else {
               arr[rowIndex] [col] = arr[rowIndex] [col] + firstSmallest;
            }
         }
      }
      int result = Integer.MAX_VALUE;
      for (int colIndex = 0; colIndex < arr[0].length; colIndex++) {
         result = Math.min(result, arr[arr.length - 1][colIndex]);
      }
      return result;
   }
}
