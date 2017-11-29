package ProjectEuler;
import java.util.*;


class LargestPalingdromeProductImpl{
	Stack<Integer>s = new Stack<Integer>();
	public void LargestPalingdrome() {
		
		for(int i=999;i>100;i--) {
			for(int j=999;j>100;j--) {
				int product = i*j;
				
				if(!ischeckPalingdrome(product)) {
					break;
				}
			}
		}
	}
	public boolean ischeckPalingdrome(int product) {
		boolean result = false;
		int countElements =0;
		int tempProduct=product;
		while(tempProduct>0) {
			tempProduct = tempProduct%10;
			countElements++;
		}
		tempProduct = product;
		for(int i=0;i<countElements/2;i++) {
			 	
			s.push(tempProduct%10);
			tempProduct = tempProduct%10;
		}
		while(s.isEmpty()) {
			int temp = s.pop();
			tempProduct = tempProduct/10;
			if(temp == tempProduct) {
				result =true;
			}
			result =false;
		}
		return result;
	}
}
public class LargestPalingdromeProductApp {
	public static void main(String[] args) {
		new LargestPalingdromeProductImpl().LargestPalingdrome();
	}
}
