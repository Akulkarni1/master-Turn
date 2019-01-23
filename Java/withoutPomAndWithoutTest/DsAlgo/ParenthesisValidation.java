package Algorithm;

import java.util.Stack;

public class ParenthesisValidation {
	public static void main(String[] args) {
		System.out.println(isParenthesisBalanced("(())"));
	}
	public static boolean isParenthesisBalanced(String str) {
		boolean result = false;
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'||str.charAt(i)=='<') {
				stack.push(str.charAt(i));
				
			}	
			else {
				if(!stack.isEmpty()) {
					//char ch =stack.pop();
					if(stack.pop()=='('&&str.charAt(i)==')')
					result = true;
					else if(stack.pop()=='['&&str.charAt(i)==']')
						result = true;
					else if(stack.pop()=='{'&& str.charAt(i)=='}')
						result = true;
					else if(stack.pop()=='<'&& str.charAt(i)=='>')
						result = true;
				}
				else {
					return false;
				}
			}
		}
		return result;
	}
}