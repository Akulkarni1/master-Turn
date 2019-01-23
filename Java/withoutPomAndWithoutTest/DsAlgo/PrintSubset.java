package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class PrintSubset {
	public static void main(String[] args) {
		int a[]= {1,2,3,4}; 
		
		List<Integer> ans=new ArrayList<Integer>();
		for(int k=1;k<=a.length;k++){ 
			for(int i=0;i<=a.length-k;i++){
				String s=""; 
				for(int j=i;j<i+k;j++)
					s+=a[j]; 
					if(s!="") 
						ans.add(Integer.parseInt(s)); 
					}
			}
		System.out.println(ans); 
		permutation(a);
	} 

	public static void permutation(int [] a) {
		int  n= a.length;
		 for (int i = 0; i < Math.pow(2,n); i++)
		    {
		        for (int j = 0; j <Math.pow(2,n); j++){
		            if((i & (1<<j)) > 0 ){
		                //System.out.print("("+i+" "+j+")"+" ");
		                System.out.print(a[j]+" ");
		            }
		        }
		       System.out.println();
		    }
		}
}



