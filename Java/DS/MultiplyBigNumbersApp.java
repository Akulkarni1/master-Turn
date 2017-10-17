import java.util.ArrayList;

public class MultiplyBigNumbersApp {
	public static void main(String[] args) {
		String s1="123";
		String s2 = "12";
		System.out.print(prod(s1,s2));
}
	public static String prod(String newValstr1, String newValstr2){
		String res = new String("0");
		
		int count = 0;
		for(int i = newValstr2.length()-1; i>=0 ; i--){
			int d2 = newValstr2.charAt(i)-'0';
			
			int carry = 0;
			StringBuffer prod = new StringBuffer();
			for(int j = newValstr1.length()-1; j>=0; j--){
				int d1 = newValstr1.charAt(j)-'0';
				int p = carry+(d1*d2);
				prod.append(p%10);
				carry = p/10;
			}
			
			if(carry != 0){
				prod.append(carry);
			}
			
			prod.reverse();

			for(int k = 0; k<count; k++){
				prod.append(0);
			}
			
			res = add(res, prod.toString());
			count++;
		}
		
		return res.toString();
	}

	//O(n);
	private static String add(String newValstr1, String newValstr2){
		StringBuffer res = new StringBuffer();
		
		int i = newValstr1.length()-1;
		int j = newValstr2.length()-1;
		int carry = 0;
		while(true){
			if(i < 0 && j < 0){
				break;
			}
			
			int d1 = i < 0 ? 0 : newValstr1.charAt(i--)-'0';
			int d2 = j < 0 ? 0 : newValstr2.charAt(j--)-'0';
			int sum = d1+d2+carry;
			
			res.append(sum%10);
			carry = sum/10;
		}
		
		if(carry != 0){
			res.append(carry);
		}
		
		return res.reverse().toString();
	}
}	
