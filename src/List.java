
// Define the operations we would like to implement
// User instantiates List as the list interface
public interface List<T extends Comparable<T>> {
	public void insert(T data);
	public void remove(T data);
	public void traverseList();
	public int size();
	public void findMiddle();
	public Node<T> getMiddleNode();
	public void reverse();
}
