package AllTime;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParenthesis {

    /*
Longest valid parenthesis.
*/
    public int longestValidParenthesis(String s) {
        int maxLength = 0, end = -1;
        Deque<Integer> leftParenthesis = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftParenthesis.addFirst(i);
            } else if (leftParenthesis.isEmpty()) {
                end = i;
            } else {
                leftParenthesis.removeFirst();
                int start = leftParenthesis.isEmpty() ? end : leftParenthesis.peekFirst();
                maxLength = Math.max(maxLength, i - start);
            }
        }
        return maxLength;
    }
}