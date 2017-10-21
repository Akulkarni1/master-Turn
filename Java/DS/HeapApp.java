
class Node {
	int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	Node(int newVal) {
		data = newVal;
	}

}

class HeapImpl {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;

	HeapImpl(int newValSize) {
		maxSize = newValSize;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean insert(int newValData) {
		if (currentSize == maxSize)
			return false;
		Node newNode = new Node(newValData);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;

	}

	public void trickleUp(int newValIndex) {
		int parent = (newValIndex - 1) / 2;
		Node bottom = heapArray[newValIndex];
		while (newValIndex > 0 && heapArray[parent].getData() < bottom.getData()) {
			heapArray[newValIndex] = heapArray[parent];
			newValIndex = parent;
			parent = (parent - 1) / 2;
		}
		heapArray[newValIndex] = bottom;
	}

	public Node remove() { 
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int newValIndex) {
		int largerChild;
		Node top = heapArray[newValIndex]; 
		while(newValIndex < currentSize/2) { 
			int leftChild = 2*newValIndex+1;
			int rightChild = leftChild+1;
	
			if(rightChild < currentSize && 	heapArray[leftChild].getData() <heapArray[rightChild].getData())
				largerChild = rightChild;
			else
				largerChild = leftChild;
			if( top.getData() >= heapArray[largerChild].getData())
				break;
			heapArray[newValIndex] = heapArray[largerChild];
			newValIndex = largerChild; 
		} 
	heapArray[newValIndex] = top;
	}
	
	public boolean change(int index, int newValue) {
		if (index < 0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].getData();
		heapArray[index].setData(newValue); 
		if (oldValue < newValue) 
			trickleUp(index); 
		else 
			trickleDown(index); 
		return true;
	} 
	public int findFirst() {
		System.out.println(heapArray[0].getData());
		return heapArray[0].getData();
	}
	//Finding the n-th decreasing/increasing the elements.
	public int findNthPosition(int n) {
		try {
		if(currentSize>n) {
		System.out.println(heapArray[n-1].getData());
		return heapArray[n-1].getData();
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	public void displayHeap(){
	
		System.out.print("heapArray: ");
		for(int m=0; m<currentSize; m++)
		if(heapArray[m] != null)
			System.out.print( heapArray[m].getData() + " ");
		else
			System.out.print("");
		System.out.println();
	
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0; 
		String dots = ".........";
		System.out.println(dots+dots); 
		while(currentSize > 0) 	{
			if(column == 0) 
			for(int k=0; k<nBlanks; k++) 
				System.out.print("");
		
			System.out.print(heapArray[j].getData());
			if(++j == currentSize) 
				break;
			if(++column==itemsPerRow) {
				nBlanks /= 2; 
				itemsPerRow *= 2; 
				column = 0; 
				System.out.println(); 
			}
			else 
				for(int k=0; k<nBlanks*2-2; k++)
					System.out.print(""); 
		} 
		System.out.println(" "+dots+dots); 
	} 
}
public class HeapApp {

}
