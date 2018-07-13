package ArrayRotation;

class ArrayRotate{
	int a[];
	int rotationPoint;
	ArrayRotate(int []data,int rp){
		a = new int[data.length];
		for(int i=0;i<data.length;i++)
			a[i]= data[i];
		rotationPoint =rp;
	}
	public void populateArray() {
		int[] temp =new int [a.length];
		int count =0;
		int tempRp= rotationPoint;
		while(tempRp<a.length) {
			temp[count]= a[tempRp];
			count++;
			tempRp++;
		}
		for(int i=0;i<rotationPoint;i++) {
			temp[count]= a[i];
			count++;
		}
		for(int i: temp) {
			System.out.println(i);
		}
	}
}
public class RotateArrayImpl {
	public static void main(String[] args) {
		int [] a= {0,1,2,3,4,5,6,7};
		int rp =2;
		new ArrayRotate(a,rp).populateArray();
	}
}
