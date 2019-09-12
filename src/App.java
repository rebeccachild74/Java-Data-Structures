package src;

public class App {

	public static void main(String[] args) {

		// LinkedList Stack
//		Stack<Integer> intStack = new Stack<>();
//		
//		intStack.push(10);
//		intStack.push(100);
//		intStack.push(1000);
//
//		System.out.println(intStack.size());
//		
//		System.out.println(intStack.peek());
//		
//		System.out.println(intStack.pop());
//		System.out.println(intStack.pop());
//		System.out.println(intStack.pop());
		
		// Array Stack
		ArrayStack<Integer> myStack = new ArrayStack<>();
		
		myStack.push(10);
		myStack.push(100);
		myStack.push(1000);
		
		System.out.println(myStack.size());
		
		System.out.println(myStack.peek());
		
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
}
