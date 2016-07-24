package test.hacker.rank.data.structures;

public class Stack {

	public String[] stack;

	public Integer topOfStack;

	public Stack(Integer size) {

		this.stack = new String[size];
		this.topOfStack = 0;
		java.util.Arrays.fill(this.stack, "-1");
	}

	private void pop() {

		if (topOfStack == null) {
			System.out.println("This stack is empty");
		} else {
			this.stack[topOfStack - 1] = "-1";
			this.topOfStack--;
		}
	}
	
	/**
	 * Spit out the first element
	 */
	private void peek() {
		// TODO Auto-generated method stub

	}

	private void push(String newElement) {

		if (topOfStack==null) {
			
		}
		
		if (this.topOfStack + 1 > stack.length) {
			System.out.println("This stack is full");
		} else {
			
			this.stack[this.topOfStack] = newElement;
			this.topOfStack++;
		}
	}

	public static void main(String[] args) {

		Stack myStack = new Stack(12);

		myStack.push("Nikos");
		myStack.push("Androniki");
		myStack.push("Vaso");
		myStack.push("Thodoris");

		myStack.pop();

		for (String string : myStack.stack) {
			System.out.println(string);
		}

		System.out.println(myStack.topOfStack);

	}
}
