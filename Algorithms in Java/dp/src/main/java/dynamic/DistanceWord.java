package dynamic;

import java.util.Arrays;

public class DistanceWord {
    public static void main(String[] args) {
    }
//    Compute the LEVENSHTEIN distnace in the spell

    public int levenshteinDistance(String string1, String string2) {
        int[][] distanceBetweenPrefix = new int[string1.length()][string2.length()];
        for (int[] row : distanceBetweenPrefix) {
            Arrays.fill(row, -1);
        }
        return computeDistancePrefix(string1, string1.length() - 1, string2, string2.length() - 1, distanceBetweenPrefix);
    }

    public int computeDistancePrefix(String string1, int string1Length, String string2, int string2Length, int[][] distanceBetweenPrefix) {
        if (string1Length < 0) {
            return string2Length + 1;
        } else if (string2Length < 0) {
            return string1Length + 1;
        }
        if (distanceBetweenPrefix[string1Length][string2Length] == -1) {
            if (string1.charAt(string1Length) == string2.charAt(string2Length)) {
                distanceBetweenPrefix[string1Length][string2Length] = computeDistancePrefix(string1, string1Length - 1, string2, string2Length - 1, distanceBetweenPrefix);
            } else {
                int substituteLast = computeDistancePrefix(string1, string1Length - 1, string2, string2Length - 1, distanceBetweenPrefix);
                int addLast = computeDistancePrefix(string1, string1Length, string2, string2Length - 1, distanceBetweenPrefix);
                int deleteLast = computeDistancePrefix(string1, string1Length - 1, string2, string2Length, distanceBetweenPrefix);
                distanceBetweenPrefix[string1Length][string2Length] = 1 + Math.min(substituteLast, Math.min(addLast, deleteLast));
            }
        }
        return distanceBetweenPrefix[string1Length][string2Length];
    }
}