
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

}
