import java.util.*;

class Data {
	int value;

	Data(int newVal) {
		value = newVal;
	}

	public int getValue() {
		return value;
	}

}

class HashTableImpl {
	private Data[] hashArray;
	private int arraySize;
	private Data nonItem;

	HashTableImpl(int size) {
		arraySize = size;
		hashArray = new Data[arraySize];
		nonItem = new Data(-1);
	}

	public void displayTable() {
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null)
				System.out.print(hashArray[j].getValue() + "");
			else
				System.out.print("");
		}
		System.out.println("");
	}

	public int hashFunc1(int key) {
		return key % arraySize;
	}

	public int hashFunc2(int key) {
		return 5 - key % 5;
	}

	public void insert(int key, Data item) {
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);

		while (hashArray[hashVal] != null && hashArray[hashVal].getValue() != -1) {
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = item;
	}

	public Data delete(int key) {
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getValue() == key) {
				Data temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return null;
	}

	public Data find(int key) {
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getValue() == key)
				return hashArray[hashVal];
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return null; // can’t find item
	}

}

public class HashTableApp {

}
