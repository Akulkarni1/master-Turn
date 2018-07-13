import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

class SortingImpl {
	class Emp {
		int id;
		String name;

		Emp() {
			id = 0;
			name = "";
		}

		Emp(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String toString() {
			return " " + id + " " + name;
		}
	}

	public ArrayList<Emp> createEmp(int newVal) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		int count = 0;
		while (count < newVal) {
			Random r = new Random();
			int temp = r.nextInt(20);
			if (!hm.containsKey(temp)) {
				hm.put(temp, "" + temp);
				count++;
			}
		}
		ArrayList result = new ArrayList<Emp>();
		Set<Map.Entry<Integer, String>> entryset = hm.entrySet();
		for (Entry<Integer, String> e : entryset) {
			result.add(new Emp(e.getKey(), e.getValue()));
		}
		return result;
	}

	public ArrayList<Emp> populateEmp() {
		ArrayList<Emp> empList = createEmp(10);// For 10 Employees are created.
		System.out.println(empList);
		return empList;
	}

	public void bubbleSort(ArrayList<Emp> empList) {
		boolean numberSwitched;
		try {
			Emp[] arr = (Emp[]) empList.toArray();
			do {
				numberSwitched = false;
				for (int i = 0; i < empList.size(); i++) {
					if (arr[i + 1].getId() < arr[i].getId()) {
						Emp temp = arr[i + 1];
						arr[i + 1] = arr[i];
						arr[i] = temp;
						numberSwitched = true;

					}

				}
			} while (numberSwitched);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertSort(ArrayList<Emp> list) {
		Emp temp = new Emp();
		Emp[] sortedlist = new Emp[list.size()];
		sortedlist = (Emp[]) list.toArray();
		for (int i = 1; i < sortedlist.length; i++) {
			for (int j = i; j > 0; j--) {
				if (sortedlist[i].getId() < sortedlist[j - 1].getId()) {
					temp = sortedlist[j];
					sortedlist[j] = sortedlist[j - 1];
					sortedlist[j - 1] = temp;
				}

			}
		}

	}

	public void quickSort(ArrayList<Emp> list) {
		if (list == null || list.size() == 0) {
			return;
		}
		Emp[] sortedlist = new Emp[list.size()];
		sortedlist = (Emp[]) list.toArray();
		quickSortImpl(0, sortedlist.length - 1, sortedlist);
	}

	public void quickSortImpl(int lowIndex, int highIndex, Emp[] list) {
		int i = lowIndex;
		int j = highIndex;
		int pivot = list[lowIndex + (highIndex - lowIndex) / 2].getId();
		while (i <= j) {
			while (list[i].getId() < pivot) {
				i++;
			}
			while (list[j].getId() > pivot) {
				j--;
			}
			if (i <= j) {
				list = swpEmp(i, j, list);
				i++;
				j--;
			}
		}
		if (lowIndex < j)
			quickSortImpl(lowIndex, j, list);
		if (i < highIndex)
			quickSortImpl(i, highIndex, list);

	}

	public Emp[] swpEmp(int i, int j, Emp[] list) {
		Emp temp = list[i];
		list[i] = list[j];
		list[j] = temp;

		return list;
	}

	public void mergeSortImpl(ArrayList<Emp> list) {
		Emp[] toSortList = new Emp[list.size()];
		int length = toSortList.length;
		Emp[] tempMerge = new Emp[list.size()];
		doMergeSort(0, length - 1, toSortList, tempMerge);

	}

	public void doMergeSort(int low, int high, Emp[] arr, Emp[] tempMerge) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			doMergeSort(low, middle, arr, tempMerge);
			doMergeSort(middle + 1, high, arr, tempMerge);
			mergePart(low, middle, high, arr, tempMerge);
		}
	}

	public void mergePart(int low, int middle, int high, Emp[] arr, Emp[] tempMerge) {
		for (int i = low; i <= high; i++) {
			tempMerge[i] = arr[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (tempMerge[i].getId() <= tempMerge[j].getId()) {
				arr[k] = tempMerge[j];
				i++;
			} else {
				arr[k] = tempMerge[j];
				j++;
			}
			k++;
		}
		while (i < middle) {
			arr[k] = tempMerge[i];
			k++;
			i++;
		}
	}
}

public class SortingApp {
	public static void main(String[] args) {
		// SortingImpl e= new SortingImpl();
		// ArrayList<SortingImpl.Emp> t = new SortingImpl().populateEmp();
		// e.bubbleSort(t);
		// e.insertSort(t);
	}
}
