import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		testMap();
		
		// testBinaryTreeMap();
		
		// System.out.println("--------------");
		
		// testLinedListMap();
	}
	
	private static void testMap() {
		
		ArrayList<String> array;
		long startTime, endTime;
		
		// // 
		System.out.println("Read [ Pride-and-Prejudice ].");
		array = FileOperation.readStringFromFile("Pride-and-Prejudice.txt");
		System.out.println(String.format("[ Pride-and-Prejudice ] words size: [ %d ].", array.size()));
		
		System.out.println("-------------------------");
		
		// test linked list map.
		startTime = System.nanoTime();
		LinkedListMap<String, Integer> listMap = new LinkedListMap<>();
		for (String word : array) {
			if (listMap.contains(word)) {
				listMap.add(word, listMap.get(word) + 1);
			} else {
				listMap.add(word, 0);
			}
		}
		endTime = System.nanoTime();
		System.out.println(String.format("Put in linked list map, the different word size: [ %d ].", listMap.getSize()));
		System.out.println(String.format("Count 'pride': [ %d ]", listMap.get("pride")));
		System.out.println(String.format("Count 'prejudice': [ %d ]", listMap.get("prejudice")));
		
		System.out.println(String.format("Use time: [ %.2f s].", (endTime - startTime) / 1000000000.0));
		
		System.out.println("-------------------------");
		
		startTime = System.nanoTime();
		BinaryTreeMap<String, Integer> treeMap = new BinaryTreeMap<>();
		for (String word : array) {
			if (treeMap.contains(word)) {
				treeMap.add(word, treeMap.get(word) + 1);
			} else {
				treeMap.add(word, 0);
			}
		}
		endTime = System.nanoTime();
		System.out.println(String.format("Put in binary tree map, the different word size: [ %d ].", treeMap.getSize()));
		System.out.println(String.format("Count 'pride': [ %d ]", treeMap.get("pride")));
		System.out.println(String.format("Count 'prejudice': [ %d ]", treeMap.get("prejudice")));
		
		System.out.println(String.format("Use time: [ %.2f s].", (endTime - startTime) / 1000000000.0));
	}
	
	private static void testLinedListMap() {
		
		LinkedListMap<String, Integer> listMap = new LinkedListMap();
		
		listMap.add("A", 5);
		listMap.add("B", 50);
		System.out.println("Get A: " + listMap.get("A"));
		
		listMap.remove("B");
		System.out.println("Remove B, and Get: " + listMap.get("B"));
		
		System.out.println("Contains B: " + listMap.contains("B"));
		
		listMap.add("C", 10);
		System.out.println("Contains C: " + listMap.contains("C"));
	}
	
	private static void testBinaryTreeMap() {
		BinaryTreeMap<String, Integer> treeMap = new BinaryTreeMap<>();
		
		treeMap.add("A", 5);
		treeMap.add("B", 25);
		treeMap.add("C", 15);
		
		System.out.println("Get A: " + treeMap.get("A"));
		System.out.println("Get B: " + treeMap.get("B"));
		System.out.println("Get C: " + treeMap.get("C"));
		
		treeMap.add("A", 66);
		System.out.println("Get A: " + treeMap.get("A"));
		
		treeMap.set("A", 13);
		System.out.println("Set A to 13, and get: " + treeMap.get("A"));
		
		System.out.println("Contains A: " + treeMap.contains("A"));
		System.out.println("Contains Z: " + treeMap.contains("Z"));
		
		treeMap.remove("B");
		System.out.println(treeMap.get("B"));
	}
}
