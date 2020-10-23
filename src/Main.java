

public class Main {
	
	public static void main(String[] args) {
		
		// LinkedListTest();
		BinaryTreeTest();
	}
	
	private static void BinaryTreeTest() {
		System.out.println("This is tree.");
		
		BinaryTree tree = new BinaryTree();
		tree.add(5);
		System.out.println("Tree size: " + tree.getSize());
		
		tree.add(5);
		System.out.println("Tree size: " + tree.getSize());
		
		System.out.println("Contains 5: " + tree.contains(5));
		
	}
	
	private static void LinkedListTest() {
		LinkedList<Integer> array = new LinkedList<Integer>();
		
		System.out.println(array.toString());
		
		array.addFirst(5);
		System.out.println(array.toString());
		
		array.addFirst(6);
		System.out.println(array.toString());
		
		array.addFirst(7);
		System.out.println(array.toString());
		
		array.add(1, 99);
		System.out.println(array.toString());
		
		array.addLast(99);
		System.out.println(array.toString());
		
		
		array.removeElements(99);
		System.out.println(array.toString());
	}
	
}
