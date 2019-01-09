package Algorithm;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindromeSeqApp {
    public static String normalize(final String s){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('$');
        for(int i=0;i<s.length();i++){
            stringBuffer.append(s.charAt(i));
            stringBuffer.append('$');

        }
        return stringBuffer.toString();
    }
    public static String longPanlingdrome(String in){
        final String s = normalize(in);
        int c =0;
        int max =0;
        int []p= new int [s.length()];
        for(int i =0;i<p.length;i++){
            p[i]=0;
        }
        for(int i=1;i<s.length()-1;i++){
            int i_mirror= 2*c-i;
            p[i]= max>i?Math.min(p[i_mirror],max-i):0;
            while ((i + p[i] + 1) < s.length() && (i - p[i] - 1) >= 0
                    && s.charAt(i + p[i] + 1) == s.charAt(i - p[i] - 1)) {
                p[i]++;
            }
            if (i + p[i] > max) {
                c = i;
                max = i + p[i];
            }
        }
        return extractLongest(in, p);
    }

    private static String extractLongest(String in, int[] p) {
        int longestCenter = 0;
        int longestLength = 0;

        for (int i = 0; i < p.length; i++) {
            if (p[i] > longestLength) {
                longestLength = p[i];
                longestCenter = i;
            }
        }

        final int offset = (longestCenter - longestLength) / 2;
        return in.substring(offset, offset + longestLength);
    }

    public Set<String> allPalindromicSubstring(final String in, final int[] P) {
        final HashSet<String> all = new HashSet<String>();

        for (int i = 0; i < P.length; i++) {
            if (P[i] != 0) {
                final int offset = (i - P[i]) / 2;
                all.add(in.substring(offset, offset + P[i]));
            }
        }

        return all;
    }
}


