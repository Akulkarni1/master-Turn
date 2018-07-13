import java.util.*;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<Integer, Integer> t = new HashMap<Integer, Integer>();
		int i = 0;
		while (i < 8) {
			for (int j = 11; j < 18; j++) {
				t.put(j, i);
				i++;
			}

		}
		System.out.println(t);
	}
}
