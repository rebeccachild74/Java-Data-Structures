
public class App {

	public static void main(String[] args) {
		
		List<Integer> intList = new LinkedList<Integer>();
		
		intList.insert(10);
		intList.insert(-2);
		intList.insert(3);
		intList.insert(100);
		
		intList.remove(10);
		
		System.out.println(intList.size());
		
		intList.traverseList();
		
		System.out.println();
		
		List<Person> personList = new LinkedList<Person>();
		
		personList.insert(new Person(10, "Blake"));
		personList.insert(new Person(23, "Sherri"));
		personList.insert(new Person(89, "Oldie"));
		personList.insert(new Person(1, "Tommy"));
		personList.insert(new Person(43, "Marie"));
		personList.insert(new Person(23, "Sam"));
		
		personList.traverseList();
		
	}
}
