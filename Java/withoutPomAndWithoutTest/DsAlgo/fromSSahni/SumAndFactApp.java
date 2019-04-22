package Algorithm.fromSSahni;
class SumAndFact{
    public void sumWithoutRec(int []arr){
        int sum =0;
        for(int data:arr){
            sum += data;
        }
        System.out.println(sum);
    }
    public void sumWithRec(int[] arr){
        int sum =0;
        int start = 0;
        int end = arr.length;
        sum = sumRec(arr, end);
        System.out.println(sum);
    }

    private int sumRec(int[] arr, int end) {
        if (end <= 0)
            return 0;
        return (sumRec(arr, end - 1) + arr[end - 1]);
    }
    public int fact(int n){
        int result=1;
        for(int i=1;i<n;i++){
            result +=i;
        }
        return result;
    }
    public int factRec(int n){
        int result =0;
        result = factorial(n);
        return result;
    }

    private int factorial(int n) {
        if(n==0||n==1){
            return 1;
        }
        else{
            return fact(n-1)+n;
        }

    }

    public void transponse(int[][]data){
        int row =0;
        int column=0;
        int [][]transpose = new int [data.length][data[0].length];
        for(int i =0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                transpose[column][row]= data[i][j];
                column++;
                row++;

            }
        }
    }
    public void add(int [] array, int data){
        int [] arr = new int[array.length+1];
        int count=0;
        for(int i:array){
            arr[count]=i;
            count++;
        }
        arr[count]=data;
        print(arr);
    }

    private void print(int[] arr) {
        for(int i:arr)
        System.out.println(i);
    }



}

public class SumAndFactApp{
    public static void main(String[] args){
        int [] data = {1,2,3,45,6,46,53,23};
        new SumAndFact().sumWithoutRec(data);
        new SumAndFact().sumWithRec(data);
        System.out.println(new SumAndFact().fact(4));
        System.out.println(new SumAndFact().factRec(4));
        new SumAndFact().add(data,21);

    }
}
