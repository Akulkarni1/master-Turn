package Time;

import java.util.*;

public class Collection {

	interface Add {
		public int add(int a, int b);
	}

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Amit", 1);
		hm.put("Sam", 3);
		hm.put("Ashu", 2);
		hm.put("Vinayak", 4);
		hm.put("Maha", 5);

		for (Map.Entry<String, Integer> i : hm.entrySet()) {
			System.out.println(i.getKey() + "" + i.getValue());
		}

		hm.forEach((k, v) -> System.out.println(k + "" + v));
		// int c=0;
		// Add c =().add(a, b)->{return a+b;};
		Add c = (a, b) -> {
			return a + b;
		};
		System.out.println(c.add(2, 4));

	}

}
