package Time;

import java.util.Stack;
//This class will improve further.
class StackImpl {
	Stack<Character> charStack = new Stack<Character>();

	public boolean validateBrackets(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				charStack.push(s.charAt(i));
			} else if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
				if (s.charAt(i) == '}' && charStack.peek() == '{')
					charStack.pop();
				if (s.charAt(i) == ']' && charStack.peek() == '[')
					charStack.pop();
				if (s.charAt(i) == ')' && charStack.peek() == '(')
					charStack.pop();
			}
		}

		if (!charStack.isEmpty()) {
			System.out.println(charStack.size());
			return false;
		}
		return true;
	}
}

public class StackApp {
	public static void main(String[] args) {
		System.out.println(new StackImpl().validateBrackets("((([])))"));
	}
}
