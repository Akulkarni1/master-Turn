/*
Merge two arrays.
@author Amit.K.
 */

class MergeImpl{
    int []a;
    int []b;
    MergeImpl(int newVala[],int[] newValb) {
        a = newVala;
        b = newValb;
    }
    public void merge(){
        int [] result = new int[a.length+b.length];
        int i=0;
        int j=0;
        int count =0;
        while(i<a.length &&j<b.length){
            if(a[i]<b[j]){
                result[count] =a[i];
                count++;
                i++;
            }
            else{
                result[count]= b[j];
                count++;
                j++;
            }
        }
        while(i<a.length){
            result[count] = a[i];
            count++;
            i++;
        }
        while(j<b.length){
            result[count] = b[j];
            count++;
            j++;
        }
        for(int l:result)
        System.out.println(l);
    }
}

public class MergeApp {
    public static void main(String[] args){
        int [] a = {1,2,3,5,6,7};
        int [] b ={11,22,33,44,55,66};
        new MergeImpl(a,b).merge();
    }

}
