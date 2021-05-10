package AllTime;

public class MinimumLengthSubstringWithAllChars {
    /*
    Minimum substring of S containing elements in T.
For Example
S=adobecodebanc
T=abc
answer=’banc’
*/

    public String minLenSubStringWithAllChars(String str, String t) {
        int[] testHist = new int[256];
        int[] pathHist = new int[256];
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int bestStart = 0;
        int bestEnd = 0;
        for (end = 0; end < t.length(); end++) {
            testHist[str.charAt(end)]++;
            pathHist[t.charAt(end)]++;
        }
        while (start < str.length()) {
            int matches = countMatches(testHist, pathHist);
            if (matches < t.length() && end < str.length()) {
                testHist[str.charAt(end)]++;
                end++;
            } else if (matches >= t.length()) {
                if (end - start < minLen) {
                    minLen = end - start;
                    bestStart = start;
                    bestEnd = end;
                }
                testHist[str.charAt(start)]--;
                start++;
            } else {
                break;
            }
        }
        return str.substring(bestStart, bestEnd);
    }

    private static int countMatches(int[] testHist, int[] pathHist) {
        int match = 0;
        for (int i = 0; i < 256; i++) {
            if (pathHist[i] > 0 && testHist[i] > 0) {
                match++;
            }
        }
        return match;
    }
}