package AllTime;

import java.util.ArrayList;
import java.util.List;

public class JustifyText {
    /*
if A = ("The", "quick", "brown", "fox", "jumped", "over",
"the", "lazy", "dogs.") and the line length L is 11, then the returned re¬
lazy” ,
quick” , “brownL_11_11_1fox” , “jumpecLover” , “the
sult should be “The
“dogs . _ _ _ _ _ _ . The symbol denotes a blank.
i
ii
11
1 1 11 1 1
i
Write a program which takes as input an array A of strings and a positive integer L,
and computes the justification of the text specified by A.
*/
    public List<String> justifyText(String[] words, int l) {
        int currLineStart = 0, numsWordCurrLine = 0, currLineLength = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words[i].length(); i++) {
            ++numsWordCurrLine;
            int lookAheadLineLength = currLineLength + words[i].length() + (numsWordCurrLine - 1);
            if (lookAheadLineLength == l) {
                result.add(joinLineWithSpace(words, currLineStart, i, i - currLineStart));
                currLineStart = i + 1;
                numsWordCurrLine = 0;
                currLineLength = 0;
            } else if (lookAheadLineLength > l) {
                result.add(joinLineWithSpace(words, currLineStart, i - 1, l - currLineLength));
                currLineStart = i;
                numsWordCurrLine = i;
                currLineLength = words[i].length();
            } else {
                currLineLength += words[i].length();
            }
        }
        if (numsWordCurrLine > 0) {
            StringBuilder lines = new StringBuilder(joinLineWithSpace(words, currLineStart, words.length - 1, numsWordCurrLine - 1));
            for (int i = 0; i < l - currLineLength - (numsWordCurrLine - 1); i++) {
                lines.append(' ');
            }
            result.add(lines.toString());
        }
        return result;
    }

    private String joinLineWithSpace(String[] words, int start, int end, int numspace) {
        int numWordscurrLine = end - start + 1;
        StringBuilder line = new StringBuilder();
        for (int i = start; i < end; i++) {
            line.append(words[i]);
            --numWordscurrLine;
            int numCurrspace = (int) Math.ceil((double) numspace / numWordscurrLine);
            for (int j = 0; j < numCurrspace; j++) {
                line.append(" ");
            }
            numspace -= numCurrspace;
        }
        line.append(words[end]);
        for (int i = 0; i < numspace; i++) {
            line.append(" ");
        }
        return line.toString();
    }
}