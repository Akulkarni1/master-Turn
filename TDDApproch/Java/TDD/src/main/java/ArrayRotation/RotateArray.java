package ArrayRotation;

public class RotateArray {
    int array[];

    RotateArray(int t){
        array = new int [t];
    }

    public int[] rotate(int[] array, int rotateBy) {
        int [] rotate = new int[array.length];
        int count=0;
        if(rotateBy==0){
            return array;
        }
        else {
            for (int i = rotateBy; i < array.length; i++) {
                rotate[count] = array[i];
                count++;
            }
            for (int i = 0; i < rotateBy; i++) {
                rotate[count] = array[i];
                count++;
            }
            return rotate;
        }
    }


    public int findLoc(int[] arr, int l,int h,int key) {

            if (l > h)
                return -1;

            int mid = (l+h)/2;
            if (arr[mid] == key)
                return mid;


            if (arr[l] <= arr[mid])
            {
                if (key >= arr[l] && key <= arr[mid])
                    return findLoc(arr, l, mid-1, key);

                return findLoc(arr, mid+1, h, key);
            }

            if (key >= arr[mid] && key <= arr[h])
                return findLoc(arr, mid+1, h, key);

            return findLoc(arr, l, mid-1, key);

    }

    public int findLoc(int[] roatatedArray, int findTheElement) {
        return findLoc(roatatedArray,0,roatatedArray.length,findTheElement);
    }

}

