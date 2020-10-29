import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		testSet();
		
		// testBinaryTreeSet();
		
		// System.out.println("--------------");
		
		// testLinedListSet();
	}
	
	private static void testSet() {
		
		ArrayList<String> array;
		long startTime, endTime;
		
		// 
		System.out.println("Read [ The-Scarlet-Letter ].");
		array = FileOperation.readStringFromFile("The-Scarlet-Letter.txt");
		System.out.println(String.format("[ The-Scarlet-Letter ] words size: [ %d ].", array.size()));
		
		System.out.println("-------------------------");
		
		// test linked list set.
		startTime = System.nanoTime();
		LinkedListSet<String> listSet = new LinkedListSet<>();
		for (String word : array) {
			listSet.add(word);
		}
		endTime = System.nanoTime();
		System.out.println(String.format("Put in linked list set, the different word size: [ %d ].", listSet.getSize()));
		System.out.println(String.format("Use time: [ %.2f s].", (endTime - startTime) / 1000000000.0));
		
		System.out.println("-------------------------");
		
		startTime = System.nanoTime();
		BinaryTreeSet<String> treeSet = new BinaryTreeSet<>();
		for (String word : array) {
			treeSet.add(word);
		}
		endTime = System.nanoTime();
		System.out.println(String.format("Put in binary tree set, the different word size: [ %d ].", treeSet.getSize()));
		System.out.println(String.format("Use time: [ %.2f s].", (endTime - startTime) / 1000000000.0));
		
		// System.out.println("Read [ Pride-and-Prejudice ].");
		// array = FileOperation.readStringFromFile("Pride-and-Prejudice.txt");
		// System.out.println(String.format("[ Pride-and-Prejudice ] words size: [ %d ]", array.size()));
		
	}
	
	private static void testLinedListSet() {
		LinkedListSet listSet = new LinkedListSet();
		
		int[] array = { 50, 30, 20, 11, 15, 16, 2, -1, 50 };
		for (int i = 0; i < array.length; i++) {
			listSet.add(array[i]);
		}
		System.out.println(listSet.toString());
		
		listSet.remove(16);
		System.out.println(listSet.toString());
	}
	
	private static void testBinaryTreeSet() {
		BinaryTreeSet<Integer> treeSet = new BinaryTreeSet<>();
		
		int[] array = { 30, 10, 20, 50, 39, 56, 47, 47, 10 };
		for (int i = 0; i < array.length; i++) {
			treeSet.add(array[i]);
		}
		System.out.println(treeSet.toString());
		
		treeSet.remove(30);
		System.out.println(treeSet.toString());
		
		treeSet.add(30);
		System.out.println(treeSet.toString());
	}
}
