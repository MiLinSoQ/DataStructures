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
		} else {
			if (node.val.compareTo(val) < 0) {
				node.left = add(node.left, val);
			} else if (node.val.compareTo(val) > 0) {
				node.right = add(node.right, val);
			}
			return node;
		}
		
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
	
}



