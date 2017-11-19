/*
 * Permuting Lists of Lists – Print all possible words from phone digits
Given a list of arraylists containing elements, write a function that prints 
out the permutations of of the elements such that, 
each of the permutation set contains only 1 element from
 each arraylist and there are no duplicates in the list of permutation sets.
 */
import java.util.*;

public class PermuListOfListApp {
	public void permuList(String[][] list, int start,ArrayList<String>perms) {
		if(start==list.length) {
			if(perms.size()==list.length) {
				System.out.println(perms.toString());
			}
		}
		for(int i=0;i<list[start].length;i++) {
			perms.add(list[start][i]);
			for(int j=start+1;j<=list.length;i++) {
				permuList(list,j,perms);
			}
			perms.remove(list[start][i]);
		}
		
	}
}
