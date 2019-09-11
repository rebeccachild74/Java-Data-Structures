package application;

import java.util.List;
import java.util.Arrays;
//import java.lang.Math;
import java.util.Random;

public class app {

	public static void main(String[] args) {
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
		
//		System.out.println(isAnagram("TheEyes", "TheySee"));
//		
//		char[] t1 = new char[] {'t', 'h', 'e', 'e', 'y', ' ', 'e', 's'};
//		char[] t2 = new char[] {'t', 'h', 'e', 'y', ' ', 's', 'e', 'e'};
//
//		System.out.println(betterIsAnagram(t1, t2));
		
		int[] testArray = new int[] { 1, 5, 3, 5, 5, 2, 8, 8, 4, 2};
		List<Integer> duplicates = findDupes(testArray);
		
//		System.out.print(duplicates);
//		System.out.print(betterFindDupes(testArray));
		
		reservoirSampling(testArray, 3);
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
		
		// Ideally would create a method for this chunk of code
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
	
	public static List<Integer> findDupes (int[] values) {
		
		// We know that the integer values are smaller than the length of the array
		// Create a table count of the values, if the counts are larger than 1, there are duplicates
		// I guess we return a list of those duplicates?
		
		// Using ArrayList because it's easy to add items without having to resize
		List<Integer> dupes = new java.util.ArrayList<>();
		
		int counts[] = new int[values.length];
		
		for(int i = 0; i < values.length; i++) {
			counts[values[i]]++;
		}
		
		for(int i = 0; i < counts.length; i++) {
			if(counts[i] > 1) {
				dupes.add(i);
			}
		}
		
		return dupes;
	}
	
	public static List<Integer> betterFindDupes (int[] values){
		
		List<Integer> dupes = new java.util.ArrayList<Integer>();
		
		for(int i = 0; i < values.length; i++) {
			// If the value is positive we have to flip it
			if(values[Math.abs(values[i])] > 0) {
				values[Math.abs(values[i])] = -values[Math.abs(values[i])];
			}
			else if (!dupes.contains(Math.abs(values[i]))) {
				dupes.add(Math.abs(values[i]));
			}
		}
		return dupes;
	}
	
	public static void reservoirSampling(int[] nums, int k) {
		
		// create a new array for k items
		int [] reservoir = new int[k];
		Random r = new Random();
		
		// copy the first k items from the original array
		for (int i = 0; i < reservoir.length; i++) {
			reservoir[i] = nums[i];
		}
		
		// Consider the items from the original array
		// k+1 because we have already copied k items
		// the i-th item is chosen to be included in the reservoir with probability k/i
		for(int i = k+1; i < nums.length; i++) {
			int j = r.nextInt(i)+1;
			if(j < k) reservoir[j] = nums[j];
		}
		
		//Show the k random items
		for(int num: reservoir) {
			System.out.print(num + " ");
		}
		
	}
}

