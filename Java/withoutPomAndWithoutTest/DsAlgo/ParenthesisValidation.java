import java.util.*;

public class ParenthesisValidation {
	public static void main(String[] args) {
	String[] s = {"{([{{])}","([{}])","{}[]()"};
	for(int i =0;i<s.length;i++) {
		if(isValidParenthesis(s[i])) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	}
	public static boolean isValidParenthesis(String s) {
		
			Stack<Character> stack = new Stack<Character>();
			boolean result = false;
			try {
			for(int i =0;i<s.length();i++){
				if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='(') {
					stack.push(s.charAt(i));
				}
				char c;
				if((s.charAt(i)=='}'||s.charAt(i)==']'||s.charAt(i)==')')&&!stack.isEmpty()) {
					c =stack.pop();
					if(s.charAt(i)=='}'&&c=='{')
						result = true;
					if(s.charAt(i)==']'&&c=='[')
						result = true;
					if(s.charAt(i)=='('&&c==')')
						result = true;
				}
				
			}
		}
		catch(EmptyStackException e) {
				e.printStackTrace();
		}
		return result;
	}
}
