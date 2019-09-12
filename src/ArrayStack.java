package src;

public class ArrayStack<T> {
	
	private T[] stack;
	private int numItems;
	
	public ArrayStack() {
		// We are not able to create a generic array,
		// So we use the object type
		this.stack = (T[]) new Object[1];
	}
	
	// O(1) if no resize
	public void push(T newData) {
		if(numItems == this.stack.length) {
			resize(2*this.stack.length);
		}
		
		this.stack[numItems++] = newData;
	}
	
	public T peek() {
		return this.stack[numItems - 1];
	}

	// O(1) if no resize
	public T pop() {
		T itemToPop = this.stack[--numItems];
		
		// Get rid of obsolete references!
		this.stack[numItems] = null;
		
		if(numItems > 0 && numItems == this.stack.length / 4) {
			resize(this.stack.length / 2);
		}
		
		return itemToPop;
	}
	
	public boolean isEmpty() {
		return this.numItems == 0;
	}
	
	public int size() {
		return this.numItems;
	}
	
	// O(N) 
	private void resize(int capacity) {
		
		T[] stackCopy = (T[]) new Object[capacity];
		
		for(int i = 0; i < this.numItems; i++) {
			stackCopy[i] = this.stack[i];
		}
		
		this.stack = stackCopy;
	}
}
