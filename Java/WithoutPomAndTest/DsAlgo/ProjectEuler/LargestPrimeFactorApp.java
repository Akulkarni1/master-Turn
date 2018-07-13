package ProjectEuler;
import java.util.ArrayList;
import java.util.Collections;
class LargestPrimeFactor{
	
	public ArrayList<Integer> primeNumbers(int number){
		int n= number;
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for(int i=2;i<= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        } 
        Collections.sort(factors);
        return factors;
	}
}
public class LargestPrimeFactorApp {
	public static void main(String[]args) {
	System.out.println(new LargestPrimeFactor().primeNumbers(13195));
	}
}