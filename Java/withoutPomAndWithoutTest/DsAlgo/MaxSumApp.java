package Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSumApp {
	public static void main(String[] args) {
		
		int []a ={2, -8, 3, -2, 4, -10};
		//Arrays.asList(a);
		//Does not work.
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		kadane(a);
	}
	
	public static void kadane(int[] A)
	{
		int maxSoFar = 0;

		int maxEndingHere = 0;

		int start = 0, end = 0;

		int beg = 0;

		for (int i = 0; i < A.length; i++)
		{
			maxEndingHere = maxEndingHere + A[i];

			if (maxEndingHere < 0)
			{
				maxEndingHere = 0;	// empty sub-array
				beg = i + 1;
			}

			if (maxSoFar < maxEndingHere)
			{
				maxSoFar = maxEndingHere;
				start = beg;
				end = i;
			}
		}

		System.out.println(maxSoFar);

		System.out.print("The contiguous sub-array with the largest sum is ");
		for (int i = start; i <= end; i++) {
			System.out.print(A[i] + " ");
		}
	}


}
