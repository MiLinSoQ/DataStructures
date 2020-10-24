

public class Main {
	
	public static void main(String[] args) {
		// LinkedListTest();
		BinaryTreeTest();
	}
	
	private static void BinaryTreeTest() {
		System.out.println("------------");
		
		BinaryTree tree = new BinaryTree();
		int[] nums = { 5, 3, 6, 8, 4, 2 };

		for (int i = 0; i < nums.length; i++) {
			tree.add(nums[i]);
		}

		/**
				5
			  /   \
			 3	   6 
		   /   \	 \
		  2	    4	  8

		*/

		System.out.println("Pre order.");
		tree.preOrder();

		System.out.println("In order.");
		tree.inOrder();

		System.out.println("Post order.");
		tree.postOrder();

		System.out.println("------------");
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
