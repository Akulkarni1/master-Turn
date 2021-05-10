package dynamic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatternMatching2DArray {
    public static void main(String[] args) {
    }

    //program that takes 2D array and array and checks whether array occurs in a 2D array.
    static class Attempt {
        int xPos;
        int yPos;
        int offset;

        Attempt(int x, int y, int offset) {
            xPos = x;
            yPos = y;
            this.offset = offset;
        }
    }

    int x = 0;
    int y = 0;

    public static boolean isPatternContainedInGrid(List<List<Integer>> grid, List<Integer> pattern) {
        Set<Attempt> previousAttempts = new HashSet<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (isPatternSuffixContainedStartingXY(grid, i, j, pattern, 0, previousAttempts)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPatternSuffixContainedStartingXY(List<List<Integer>> grid, int x, int y, List<Integer> pattern, int offset, Set<Attempt> previousAttempts) {
        if (pattern.size() == offset) {
            return true;
        }
        if (x < 0 || x >= grid.size() || y < 0 || y >= grid.get(x).size() || previousAttempts.contains(new Attempt(x, y, offset))) {
            return false;
        }
        if (grid.get(x).get(y).equals(pattern.get(offset)) && (isPatternSuffixContainedStartingXY(grid, x - 1, y, pattern, offset + 1, previousAttempts)
                || isPatternSuffixContainedStartingXY(grid, x + 1, y, pattern, offset + 1, previousAttempts)
                || isPatternSuffixContainedStartingXY(grid, x, y - 1, pattern, offset + 1, previousAttempts)
                || isPatternSuffixContainedStartingXY(grid, x, y + 1, pattern, offset + 1, previousAttempts))) {
            return true;
        }
        previousAttempts.add(new Attempt(x, y, offset));
        return false;
    }
}