
public class LinkedList<T extends Comparable<T>> implements List<T>{

	// Should not be visible outside of class
	private Node<T> head;
	private int sizeOfList;
	
	@Override
	public void insert(T data) {
		this.sizeOfList++;
		
		// Empty list
		if(head == null) {
			this.head = new Node<>(data);
		}
		else {
			// Create its own method because this is popular operation for linkedLists
			insertDataBeginning(data);
		}
	}

	// O(1)
	private void insertDataBeginning(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNextNode(head);
		this.head = newNode;
	}
	
	// O(n)
	private void insertDataEnd(T data, Node<T> node) {
		
		if (node.getNextNode() != null) {
			insertDataEnd(data, node.getNextNode());
		}
		else {
			Node<T> newNode = new Node<>(data);
			node.setNextNode(newNode);
			// newNode.nextNode's default value is null already
		}
	}

	@Override
	public void remove(T data) {
		
		// List is already empty
		if(this.head == null) return;
		
		this.sizeOfList--;
		
		// Checking if we are removing the head
		// compareTo method comes from the T extends Comparable<T> declaration
		if(this.head.getData().compareTo(data) == 0) {
			this.head = this.head.getNextNode();
		}
		else {
			remove(data, head, head.getNextNode());
		}
	}

	private void remove(T dataToRemove, Node<T> previousNode, Node<T> currentNode) {
		while(currentNode != null) {
			if(currentNode.getData().compareTo(dataToRemove) == 0 ) {
				// Found data to remove
				previousNode.setNextNode(currentNode.getNextNode());
				// Avoid obsolete references and for garbage collection
				currentNode = null;
				// Stop iterating
				return;
			}
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
	}

	@Override
	public void traverseList() {
		// Iteratively, can be done recursively using 2 methods
		if(this.head == null) return;
		
		Node<T> currentNode = this.head;
		
		while(currentNode != null) {
			if(currentNode.getNextNode() != null) {
				System.out.print(currentNode + " -> ");
			}
			else {
				System.out.print(currentNode);
			}
			currentNode = currentNode.getNextNode();
		}
	}

	@Override
	public int size() {
		return this.sizeOfList;
	}

	// In place algorithm to find the middle node of a LinkedList
	@Override
	public void findMiddle() {
		
		// flag for if there are 2 center nodes or not
		boolean flag = false;
		
		if(this.sizeOfList % 2 == 0) {
			flag = true;
		}
		Node<T> currentNode = this.head;
		Node<T> prevNode = this.head;
		
		for(int i = 0; i <= this.sizeOfList / 2; i++) {
			if(i == this.sizeOfList/2) {
				if(flag == false) {
					System.out.print(currentNode.getData());
				}
				else {
					System.out.print(prevNode.getData() + ", " + currentNode.getData());
				}
			}
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
	}

	@Override
	public Node<T> getMiddleNode() {
		
		Node<T> fastptr = this.head;
		Node<T> slowptr = this.head;
		
		while(fastptr.getNextNode() != null && fastptr.getNextNode().getNextNode() != null) {
			fastptr = fastptr.getNextNode().getNextNode();
			slowptr = slowptr.getNextNode();
		}
		return slowptr;
	}

	@Override
	public void reverse() {
	
		Node<T> currNode = this.head;
		Node<T> prevNode = null;
		Node<T> nextNode = null;
		
		while(currNode != null) {
			nextNode = currNode.getNextNode();
			// kind of reversing the references
			currNode.setNextNode(prevNode);
			prevNode = currNode;
			currNode = nextNode;
		}
		// Reset the head to the opposite end
		this.head = prevNode;
	}
}
