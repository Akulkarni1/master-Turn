package dynamic;

import java.util.List;

public class Maxgain {
    public static void main(String[] args) {
    }

    //pick up coin and Maximum gain
/*
Condition for the this game are
1.)an even number of coins are placed in a line
2.)Two players take turns at choosing one coin each — they can only choose
from the two coins at the ends of the line. The game ends when all the coins have
been picked up. The player whose coins have the higher total value wins. A player
cannot pass his turn.
R(a,b) = max (c(a)+min(R(a+2b), R(a+1,b-1), c(b)+min(R(a+1,b-1),R(a,b-2))));
*/
    public static int pickUpCoins(List<Integer> coins) {
        return computeMaximumRevenueForRange(coins, 0, coins.size() - 1, new int[coins.size()][coins.size()]);
    }

    private static int computeMaximumRevenueForRange(List<Integer> coins, int a, int b, int[][] maxRevenueForRange) {
        if (a > b) {
            return 0;
        }
        if (maxRevenueForRange[a][b] == 0) {
            int maxRevenueForA = coins.get(a) + Math.min(computeMaximumRevenueForRange(coins, a + 2, b, maxRevenueForRange), computeMaximumRevenueForRange(coins, a + 1, b - 1, maxRevenueForRange));
            int maxRevenueForB = coins.get(b) + Math.min(computeMaximumRevenueForRange(coins, a + 1, b - 1, maxRevenueForRange), computeMaximumRevenueForRange(coins, a, b - 2, maxRevenueForRange));
            maxRevenueForRange[a][b] = Math.max(maxRevenueForA, maxRevenueForB);
        }
        return maxRevenueForRange[a][b];
    }

}