package AllTime;

import java.util.List;

public class Searchin2Sorted {
    /*
Search in 2 sorted elements.
You are given Two sorted arrays and postive integer K. Design an algorithm for computing the kthe smallest element in an array consisiting of the element of the inital
two arrays arranged in sorted order.Array elements may be duplicated within and across the input arrays.
*/

    public int findKthTwoSortedArrays(List<Integer> data1, List<Integer> data2, int k){
        int b = Math.max(0,k-data2.size());
        int t = Math.min(data1.size(),k);
        while(b<t){
            int x= b +((t-b)/2);
            int ax1= (x<=0? Integer.MIN_VALUE: data1.get(x-1));
            int ax = (x>=data1.size()?Integer.MAX_VALUE: data1.get(x));
            int bx1 = (k-x<=0?Integer.MIN_VALUE:data2.get(k-x-1));
            int bkx = (k-x>=data2.size()?Integer.MAX_VALUE:data2.get(k-x));
            if(ax <bx1){
                b=x+1;
            }else if(ax1>bkx){
                t = x-1;
            }else{
                return Math.max(ax1,bkx);
            }
        }
        int ab1= b<=0?Integer.MIN_VALUE:data1.get(b-1);
        int bkb1 = k-b-1<0?Integer.MIN_VALUE:data2.get(k-b-1);
        return Math.max(ab1,bkb1);
    }
}
