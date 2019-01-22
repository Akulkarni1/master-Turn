package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Pratice {
	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<Integer>();
		integerList.add(2);
		integerList.add(4);
		integerList.add(6);
		integerList.add(8);
		integerList.add(12);
		integerList.add(10);
		List resultlist = integerList.stream().filter(n ->n%2==0).collect(Collectors.toList());
		
		System.out.println(resultlist);
		
		System.out.println(integerList.stream().distinct().count());
		List<Integer> integerList2 = new ArrayList<>();
		integerList2.add(1);
		integerList2.add(3);
		integerList2.add(5);
		integerList2.add(7);
		integerList2.add(9);
		integerList2.add(11);
		List<Integer> mergeList= new ArrayList<>();
		
		for(int i=0, j=0;i<integerList.size()&&j<integerList2.size();i++,j++) {
				mergeList.add(integerList.get(i));
				mergeList.add(integerList2.get(j));
			
		}
		List<Character> charList = new ArrayList<>();
		charList.add('a');
		charList.add('b');
		charList.add('c');
		charList.add('a');
		charList.add('b');
		print(charList.stream().distinct().collect(Collectors.toList()));
		System.out.println(mergeList);
		printDivisor(11);
		printDiv(11);
		
		
	}
	public static void print(Object e) {
		System.out.println(e);
	}
	public static void printDivisor(int n) {
		for(int i =1;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				if(n/i==i) {
					System.out.println(i);
				}
				else {
					System.out.println(i+" "+n/i);
				}
			}
		}
	}
	public static void printDiv(int n) {
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				System.out.println(i);
				
			}
		}
	}

}
