package dynamic;

public class CountStairsToClimb {
    public static void main(String[] args) {
    }
/*    Count the number of moves to climb stairs
Write a program which takes as inputs n and k and returns the number of ways in
which you can get to your destination. For example, if n = 4 and k = 2, there are five
ways in which to get to the destination:
• four single stair advances,
• two single stair advances followed by a double stair advance,
• a single stair advance followed by a double stair advance followed by a single
stair advance,
• a double stair advance followed by two single stairs advances, and
• two double stair advances.
*/
    public static int numberOfWaysToTop(int top, int maxStep) {
        return computeNumberToWaysToH(top, maxStep, new int[top + 1]);
    }

    private static int computeNumberToWaysToH(int n, int maxStep, int[] numberOfWaysToH) {
        if (n <= 1) {
            return 1;
        }
        if (numberOfWaysToH[n] == 0) {
            for (int i = 1; i <= maxStep && n - i >= 0; ++i) {
                numberOfWaysToH[n] += computeNumberToWaysToH(n - i, maxStep, numberOfWaysToH);
            }
        }
        return numberOfWaysToH[n];
    }
}