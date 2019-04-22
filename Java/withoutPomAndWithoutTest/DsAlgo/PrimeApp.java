package Algorithm;

public class PrimeApp {
    public static boolean isPrime(int n){
        int m = n/2;
        if(n==0||n==1){
            return false;
        } else{
            for(int i=2;i<=m;i++){
                if(n%i==0){
                    return false;
                }
            }

        }
        return true;
    }
    public static void main(String[] args){
        {
            System.out.println(isPrime(30));
        }
    }
}
