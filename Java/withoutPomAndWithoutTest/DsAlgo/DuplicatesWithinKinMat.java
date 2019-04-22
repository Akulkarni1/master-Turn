package Algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicatesWithinKinMat {
    public boolean checkDuplicateWithinK(int[][] mat, int k) {
        class Cell {
            int row;
            int col;

            public Cell(int r, int c) {
                row = r;
                col = c;


            }
        }
        int n = mat.length;
        int m= mat[0].length;
        k= Math.min(k,n*m);
        Map<Integer, Set<Cell>> slidingWindow =new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(slidingWindow.containsKey(mat[i][j])){
                    for(Cell c:slidingWindow.get(mat[i][j])){
                        int dist= Math.abs(i-c.row)+Math.abs(j-c.col);
                        if(dist<=k)
                            return true;
                        if(i-c.row>k){
                            slidingWindow.remove(c);
                        }
                    }
                    slidingWindow.get(mat[i][j]).add(new Cell(i,j));
                }
                else{
                    slidingWindow.put(mat[i][j], new HashSet<Cell>());
                    slidingWindow.get(mat[i][j]).add(new Cell(i, j));

                }
            }
        }

    return false;
    }
}