import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TempEmp {

	public void sortMapByValue() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Amit");
		map.put(2, "Narendra");
		map.put(3, "Vivek");
		map.put(4, "Vinyak");
		Set<Entry<Integer, String>> set = map.entrySet();
		List<Entry<Integer, String>> list = new ArrayList<Entry<Integer, String>>(set);
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		for (Entry<Integer, String> entry : list) {
			System.out.println(entry.getKey() + " ==== " + entry.getValue());
		}

	}

}

public class SortValueMap {
	public static void main(String[] args) {
		new TempEmp().sortMapByValue();
	}
}
