package Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ArraySumCalculator implements Runnable {

	ConcurrentHashMap<String, Integer> sumMap;
	List<Integer> integers;
	String arrayName;

	ArraySumCalculator(ConcurrentHashMap<String, Integer> sumMap, List<Integer> integers, String arrayName) {
		this.sumMap = sumMap;
		this.integers = integers;
		this.arrayName = arrayName;
	}

	@Override
	public void run() {
		int sum = 0;
		for (Integer i : integers) {
			sum += i;
		}
		sumMap.put(arrayName, sum);
	}
}

public class ExecutorServiceSample {

	public static void main(String[] args) {
		try {
			ArrayList<ArrayList<Integer>> data = new ArrayList<>();
			data = dataToSet();
			System.out.println(calculateSumUsingExecutor(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ConcurrentHashMap<String, Integer> calculateSumUsingExecutor(ArrayList<ArrayList<Integer>> data) {
		ConcurrentHashMap<String, Integer> result = new ConcurrentHashMap<String, Integer>();
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
		int i = 1;
		for (List<Integer> integers : data) {
			String arrayName = "Array " + i;
			executor.execute(new ArraySumCalculator(result, integers, arrayName));
			i++;
		}
		executor.shutdown();

		try {
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return result;
	}

	public static ArrayList<Integer> populateData(ArrayList<Integer> arrayList) {
		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			arrayList.add(random.nextInt(30));
		}
		System.out.println(arrayList);
		return arrayList;
	}

	public static ArrayList<ArrayList<Integer>> dataToSet() {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 5; i++) {
			ArrayList<Integer> t = new ArrayList<Integer>();
			t = populateData(t);
			result.add(t);
		}
		return result;
	}
}
