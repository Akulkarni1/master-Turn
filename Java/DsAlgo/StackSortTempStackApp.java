import java.util.Stack;

public class StackSortTempStackApp {
	public Stack<Integer> sortStack(Stack<Integer> input) {
		Stack<Integer> tempStack = new Stack<Integer>();
		while (input.isEmpty()) {
			int temp = input.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > temp) {
				input.push(tempStack.pop());
			}
			tempStack.push(temp);
			System.out.println("input: " + input);
			System.out.println("tmpStack: " + tempStack);
		}
		return tempStack;
	}
}
