import java.io.*;
import java.util.*;

public class BeautifulPairApp {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] a= new int[n];
        int [] b = new int[n];
        for(int i =0;i<n;i++){a[i]= s.nextInt();}
        for(int i =0;i<n;i++){b[i] = s.nextInt();}
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!right.contains(j) && a[i] == b[j]) {
                    left.add(i);
                    right.add(j);
                    break;
                }
            }
        }

        List<Integer> notPairedIndicesInB = new ArrayList<Integer>();
        for(int i = 0; i < n; ++i) {
            if (!right.contains(i))
                notPairedIndicesInB.add(i);
        }

        int bestSolution = left.size();
        bestSolution += notPairedIndicesInB.size() > 0? 1 : -1;

        System.out.println(bestSolution);

    }
}