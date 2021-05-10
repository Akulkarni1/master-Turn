package dynamic;


import java.util.Arrays;
import java.util.List;

// The thief break into clock store, Each clock has the weight and the price;
class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Knapsack {

    public static void main(String[]args){}

    public int optimumSubjectToCapacity(List<Item> items, int capacity) {
        int[][] optimumVal = new int[items.size()][capacity + 1];
        for (int[] v : optimumVal) {
            Arrays.fill(v, -1);
        }
        return optimumSubjectToItemAndCapacity(items, items.size() - 1, capacity, optimumVal);
    }

    private int optimumSubjectToItemAndCapacity(List<Item> items, int k, int availableCapacity, int[][] optimumVal) {
        if (k < 0) {
            return 0;
        }
        if (optimumVal[k][availableCapacity] == -1) {
            int withoutCurrItem = optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity, optimumVal);
            int withCurrItem = availableCapacity < items.get(k).weight ? 0 :
                    items.get(k).value + optimumSubjectToItemAndCapacity(items, k - 1, availableCapacity - items.get(k).weight, optimumVal);
            optimumVal[k][availableCapacity] = Math.max(withoutCurrItem, withCurrItem);
        }
        return optimumVal[k][availableCapacity];
    }
}