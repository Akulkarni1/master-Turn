import java.util.List;

public class TrappingWater {
   /*
   A one-dimensional container is specified by an array of n nonnegative integers, spec¬
ifying the height of each unit-width rectangle. Design an algorithm for computing
the capacity of the container.
    */

   public int calculateTrappingWater(List<Integer> data) {
      if (data.isEmpty()) {
         return 0;
      }
      int maxH = getMaxIndex(data);
      int sum = 0, left = data.get(0);
      for (int i = 1; i < maxH; i++) {
         if (data.get(i) >= left) {
            left = data.get(i);
         } else {
            sum += left - data.get(i);
         }
      }
      int right = data.get(data.size() - 1);
      for (int i = data.size() - 2; i > maxH; --i) {
         if (data.get(i) >= right) {
            right = data.get(i);
         } else {
            sum += right - data.get(i);
         }
      }
      return sum;
   }

   public int getMaxIndex(List<Integer> data) {
      int max = Integer.MIN_VALUE;
      int index = -1;
      for (int i = 0; i < data.size(); i++) {
         if (data.get(i) > max) {
            max = data.get(i);
            index = i;
         }
      }
      return index;
   }
}