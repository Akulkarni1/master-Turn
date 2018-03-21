import java.util.*;


public class MinSubArrayToSortApp {

	public static List<Integer> minListToBeSorted(int [] newVal){
		int minIndex =-1;
		for(int i =0;i<newVal.length;i++) {
			if(newVal[i]<newVal[i-1]) {
				minIndex =i;
				break;
			}
		}
		for(int i= minIndex;i<newVal.length;i++) {
			if(newVal[i]<newVal[minIndex]) {
				minIndex =i;
			}
		}
		int l = minIndex;
		int r = minIndex;
		int maxleft = newVal[l];
		while(l>=0 && newVal[l]>= newVal[minIndex]) {
			maxleft = Math.max(maxleft, newVal[l]);
			l--;
			
		}
		while(r < newVal.length && newVal[r] <= maxleft){
			r++;
		}
		
		
		List<Integer> res = new  ArrayList<Integer>();
		for(int i = l+1; l>=0 && r<=newVal.length && i<r; i++){
			res.add(newVal[i]);
		}
		return res;
	}
}


