public class BinaryTree<E extends Comparable<E>> {
	
	private class Node {
		
		public E val;
		public Node right;
		public Node left;
		
		public Node(E val) { 
			this.val = val;
			this.right = null;
			this.left = null;
		}
		
		public Node() {
			this(null);
		}
	}
	
	private Node root;
	private int size;

	
	public BinaryTree() {
		this.root = null;
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpy() {
		return this.size == 0;
	}
	
	public void add(E val) {
		this.root = add(this.root, val);
		
		// if (this.root == null) {
			// this.root = new Node(val);
			// this.size ++;
		// } else {
			// add(root, val);
		// }
	}
	
	private Node add(Node node, E val) {
		
		if (node == null) {
			this.size++;
			return new Node(val);
		} 

		if (val.compareTo(node.val) < 0) {
			node.left = add(node.left, val);
		} else if (val.compareTo(node.val) > 0) {
			node.right = add(node.right, val);
		}
		return node;
		
		// if (val.compareTo(node.val) < 0 && node.left == null) {
			// node.left = new Node(val);
			// size++;
			// return;
		// } else if (val.compareTo(node.val) > 0 && node.right == null) { // vla > node.val
			// node.right = new Node(val);
			// size++;
			// return;
		// }
		
		// if (val.compareTo(node.val) < 0) {
			// add(node.left, val);
		// } else {
			// add(node.right, val);
		// }
	}
	
	// 查看是否包含元素 val
	public boolean contains(E val) {
		return contains(this.root, val);
	}
	
	private boolean contains(Node node, E val) {
		if (node == null) return false;
		if (node.val.equals(val)) return true;
		
		if (node.val.compareTo(val) < 0) {
			return contains(node.left, val);
		} else {
			return contains(node.right, val);
		}
	}

	// 前序走訪
	public void preOrder() {
		preOrder(this.root);
	}

	private void preOrder(Node node) {
		if (node == null) return;
		System.out.print(node.val + " -> ");
		preOrder(node.left);
		preOrder(node.right);
	}
	

	// 中序走訪
	public void inOrder() {
		inOrder(this.root);
	}

	private void inOrder(Node node) {
		if (node == null) return;

		inOrder(node.left);
		System.out.print(node.val + " -> ");
		inOrder(node.right);
	}

	// 後序走訪
	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node == null) return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + " -> ");
	}
}



