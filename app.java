package application;

import java.util.List;
import java.util.Arrays;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArray[];
		
		intArray = new int [5];
		
		// Declaring array literal
		int[] otherArray = new int[] { 1, 2, 3, 4, 5, 6, 7};
		
		// Array Lists
		List<String> list = new java.util.ArrayList<>();
		
		list.add("Eddy");
		list.add("Joe");
		list.add("Rebecca");
		
		//list.remove("Eddy");
		
		Object[] array = list.toArray();
		
		//System.out.println(list.get(1));
		//System.out.println(array);
		
//		for (String s:list) {
//			System.out.println(s);
//		}
		
		// Invoking reverseArray Method
		int[] reversedArray = reverseArray(otherArray);
		
//		for (int val : reversedArray) {
//			System.out.print(val + ", ");
//		}
		
		System.out.println(isAnagram("TheEyes", "TheySee"));
		
		char[] t1 = new char[] {'t', 'h', 'e', 'e', 'y', ' ', 'e', 's'};
		char[] t2 = new char[] {'t', 'h', 'e', 'y', ' ', 's', 'e', 'e'};

		System.out.println(betterIsAnagram(t1, t2));
	}
	
	public static int[] reverseArray(int array[]) {
		int curMin = 0;
		int curMax = array.length - 1;
		
		while(curMax > array.length/2) {
			int temp = array[curMin];
			array[curMin] = array[curMax];
			array[curMax] = temp;
			curMin++;
			curMax--;
		}
		
		return array;
	}
	
	// Easily handles different cases
	public static boolean isAnagram (String w1, String w2) {
		// could create a lookup table for both words
		// If the tables match, they are anagrams
		int w1Table[] = new int[26];
		int w2Table[] = new int[26];
		
		for(int i = 0; i < w1.length(); i++) {
			w1Table[Character.toLowerCase(w1.charAt(i))-'a']++;
		}
		
		for(int i = 0; i < w2.length(); i++) {
			w2Table[Character.toLowerCase(w2.charAt(i))-'a']++;
		}
		
		for(int i = 0; i < 26; i++) {
			if (w1Table[i] != w2Table[i]) {
				return false;
			}
		}
		
		return true;
	}

	// Easily handles spaces
	public static boolean betterIsAnagram (char[] w1, char[] w2) {
		
		if(w1.length != w2.length) return false;
		
		Arrays.sort(w1);
		Arrays.sort(w2);
		
		for(int i = 0; i < w1.length; i++) {
			if (w1[i] != w2[i]) {
				return false;
			}
		}
		return true;
	}
	
}

