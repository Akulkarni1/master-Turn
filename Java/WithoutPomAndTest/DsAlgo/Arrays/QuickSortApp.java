class QuickSort{
	
	int parition(int arr[],int low, int high){
		int pivot = arr[high];
		int i= (low-1);
		for(int j= low;j<high;j++) {
			if(arr[j]<= pivot) {
				i++;
				//Swp array a[i+1]
				int temp = arr[i];
				arr[i]= arr[j];
				arr[j]= temp;
				
			}
		}
		 int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	 
	       return i+1;
	}
	void sort(int arr[],int low, int high) {
		if(low<high) {
			int pi= parition(arr, low,high);
			sort(arr, low, pi-1);
			sort(arr,pi+1,high);
		}
		print(arr);
		
	}
	public void print(int arr[]) {
		for(int i =0;i<arr.length;i++) {
			System.out.print(" "+arr[i]);
		}
	}
	
}
public class QuickSortApp {
	public static void main(String[] args) {
		int arr[]= {3,4,1,2,5,9,0,5,6,7,8};
		int n = arr.length-1;
		new QuickSort().sort(arr,0,n);
		
	}
}
