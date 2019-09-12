//import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Integer> intList = new LinkedList<Integer>();
		
		intList.insert(10);
		intList.insert(-2);
		intList.insert(3);
		intList.insert(100);
		
		//intList.remove(10);
		
		//System.out.println(intList.size());
		
		//intList.traverseList();
		
		//System.out.println();
		
		List<Person> personList = new LinkedList<Person>();
		
		personList.insert(new Person(10, "Blake"));
		personList.insert(new Person(23, "Sherri"));
		personList.insert(new Person(89, "Oldie"));
		personList.insert(new Person(1, "Tommy"));
		personList.insert(new Person(43, "Marie"));
		personList.insert(new Person(23, "Sam"));
		personList.insert(new Person(14, "Rebecca"));
		
		//personList.traverseList();
		
		// Built in linked lists
//		List<Integer> list = new java.util.LinkedList<>();
//		
//		list.add(3);
//		list.add(10);
//		list.add(20);
//		
//		// 0 is the index
//		list.remove(0);
		
//		System.out.println(list.get(1)); // Not very fast
//		
//		System.out.println(list.size());
//		
//		for(Integer i : list) {
//			System.out.print(i + " ");
//		}
//		intList.traverseList();
//		System.out.println();
//		intList.findMiddle();
//		System.out.println();
		
		personList.traverseList();
		System.out.println();
//		personList.findMiddle();
//		System.out.println();
//		
//		// betterMethod
//		System.out.println(intList.getMiddleNode().getData());
//		System.out.println(personList.getMiddleNode().getData());

		personList.reverse();
		
		personList.traverseList();
	}
}
