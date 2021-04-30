package dynamic;

public class IterateIn2DArray {
    public static void main(String[] args) {
    }
    //Count the number of ways to you can go from top-left to the bottom -right in a 2D array.

    public static int numberOfWays(int n, int m) {
        return computeNumberOfWaysToXY(n - 1, m - 1, new int[n][m]);
    }

    public static int computeNumberOfWaysToXY(int x, int y, int[][] numberOfWays) {
        if (x == 0 || y == 0) {
            return 1;
        }
        if (numberOfWays[x][y] == 0) {
            int waysToTop = x == 0 ? 0 : computeNumberOfWaysToXY(x - 1, y, numberOfWays);
            int waysToLeft = x == 0 ? 0 : computeNumberOfWaysToXY(x, y - 1, numberOfWays);
            numberOfWays[x][y] = waysToTop + waysToLeft;
        }
        return numberOfWays[x][y];
    }
    // The time complexity is O(nm) and the space complexity is O(nm) where
    // n is the number of rows and m is the number of columns.
}