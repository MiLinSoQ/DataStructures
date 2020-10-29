public class Main {
	
	public static void main(String[] args) {
		testBinaryTreeSet();
		
		System.out.println("--------------");
		
		testLinedListSet();
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
