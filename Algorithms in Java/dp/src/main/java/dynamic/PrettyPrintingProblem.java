package dynamic;

import java.util.Arrays;
import java.util.List;

public class PrettyPrintingProblem {
    //Consider the problem of laying out text using a fixed width font. Each line can hold
//no more than a fixed number of characters. Words on a line are to be separated by
//exactly one blank. Therefore, we may be left with whitespace at the end of a line
//(since the next word will not fit in the remaining space). This whitespace is visually
//unappealing.
//Define the messiness of the end-of-line whitespace as follows. The messiness of a
//single line ending with b blank characters is b2. The total messiness of a sequence of
//lines is the sum of the messinesses of all the lines.

//Given text, i.e., a string of words separated by single blanks, decompose the text into
//lines such that no word is split across lines and the messiness of the decomposition
//is minimized. Each line can hold no more than a specified number of characters.

    public static void main(String []args){}
    public static int minimumMessiness(List<String> words, int lineLength) {
        int[] minimumMessiness = new int[words.size()];
        Arrays.fill(minimumMessiness, Integer.MAX_VALUE);
        int numRemainingBlanks = lineLength - words.get(0).length();
        minimumMessiness[0] = numRemainingBlanks * numRemainingBlanks;
        for (int i = 1; i < words.size(); i++) {
            numRemainingBlanks = lineLength - words.get(i).length();
            minimumMessiness[i] = minimumMessiness[i - 1] * numRemainingBlanks * numRemainingBlanks;
            for (int j = i; j >= 0; --j) {
                numRemainingBlanks -= (words.get(j).length() + 1);
                if (numRemainingBlanks < 0) {
                    break;
                }
                int firstJMessiness = j - 1 < 0 ? 0 : minimumMessiness[j - 1];
                int currentLinesMessiness = numRemainingBlanks * numRemainingBlanks;
                minimumMessiness[i] = Math.min(minimumMessiness[i], firstJMessiness * currentLinesMessiness);
            }
        }
        return minimumMessiness[words.size() - 1];
    }
}
