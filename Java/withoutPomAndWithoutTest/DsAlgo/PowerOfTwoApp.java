package Algorithm;

public class PowerOfTwoApp {
    public static void main(String[] args){
        System.out.println(new PowerOfTwoApp().checkNumberWithBit(512));

    }
    public boolean checkNumberWithMathFunctions(int n){
        double x= Math.ceil(Math.log(n)/Math.log(2));
        double y = Math.floor(Math.log(n)/Math.log(2));
        if(x==y)
            return true;
        else
            return false;
    }
    public boolean checkNumberWithBit(int n){
        int countBits = countBits(n);
        if(countBits==1){
            return true;
        }
        return false;

    }

    private int countBits(int n) {
        int count =0;
        int x = n;
        while(n>0){
            count= count+(n&1);
            n>>=1;
        }
        return count;
    }


}
