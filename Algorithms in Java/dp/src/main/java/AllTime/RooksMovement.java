package AllTime;

import java.util.Collections;
import java.util.List;

public class RooksMovement {
    /*
which takes as input a 2D array A of Is and Os, where the Os encode
the positions of rooks on an n X m chessboard,
1 0 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1
1 1 1 1 1 0 1 1
1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1
0 1 1 1 1 0 1 1
1 1 1 1 1 1 1 1

and updates
the array to contain Os at all locations which can be attacked by rooks.


*/

    public static void rookattack(List<List<Integer>> list) {
        int m = list.size();
        int n = list.get(0).size();
        boolean hasFirstRowZero = false;
        for (int i = 0; i < n; i++) {
            if (list.get(0).get(i) == 0) {
                hasFirstRowZero = true;
                break;
            }
        }
        boolean hasFirstColumnZero = false;
        for (int i = 0; i < m; i++) {
            if (list.get(i).get(0) == 0) {
                hasFirstColumnZero = true;
                break;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (list.get(i).get(j) == 0) {
                    list.get(i).set(0, 0);
                    list.get(0).set(j, 0);
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (list.get(i).get(0) == 0) {
                Collections.fill(list.get(i), 0);
            }
        }
        for (int j = 1; j < n; j++) {
            if (list.get(0).get(j) == 0) {
                for (int i = 1; i < m; i++) {
                    list.get(i).set(j, 0);
                }
            }
        }
        if (hasFirstRowZero) {
            Collections.fill(list.get(0), 0);
        }
        if (hasFirstColumnZero) {
            for (int i = 0; i < m; i++) {
                list.get(i).set(0, 0);
            }
        }
    }

//Time complexiry  is O(nm);
}