public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("------------");
		
		BinaryTree tree = new BinaryTree();
		// int[] nums = { 8, 4, 12, 2, 6, 10, 14, 7, 5, 15, 16 ,17};
		int[] nums = { 27, 14, 35, 10, 19, 31, 42, 21 };

		for (int i = 0; i < nums.length; i++) {
			tree.add(nums[i]);
		}

		/**
				          8
						/   \    
					  4      12
					/  \    /  \
				   2    6  10   14
		*/

		System.out.println("Pre order.");
		tree.preOrder();
		System.out.println("");
		
		System.out.println("In order.");
		tree.inOrder();
		System.out.println("");
		
		System.out.println("Post order.");
		tree.postOrder();
		System.out.println("");
		
		System.out.println("Level Order.");
		tree.levelOrder();
		
		System.out.println("");
		System.out.println("------------");
		
		
		System.out.println(String.format("Minimum: [ %d ]", tree.minimum()));
		System.out.println(String.format("Maximum: [ %d ]", tree.maximum()));
		
		
		System.out.println(String.format("Floor: [ %d ]", tree.floor(11)));
		System.out.println(String.format("Ceil: [ %d ]", tree.ceil(11)));
		
		// System.out.println(String.format("Remove mim: [ %d ]", tree.removeMin()));
		// System.out.println("Pre order.");
		// tree.preOrder();
		// System.out.println("");
		
		// System.out.println(String.format("Remove max: [ %d ]", tree.removeMax()));
		// System.out.println("Pre order.");
		// tree.preOrder();
		// System.out.println("");
		
		// tree.remove(4);
		// System.out.println("Pre order.");
		// tree.preOrder();
		// System.out.println("");
		
		System.out.println(tree.toString());
		
	}
}
