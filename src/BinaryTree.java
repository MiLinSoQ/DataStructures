import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

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
	
	public boolean isEmpty() {
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
	
	// 層序走訪
	public void levelOrder() {
		if (this.root == null) return;
		
		Queue<Node> queue = new  LinkedList<>();
		queue.add(this.root);
		
		while (!queue.isEmpty()) {
			Node cur = queue.remove();
			System.out.print(cur.val + " -> ");
			if (cur.left != null) queue.add(cur.left);
			if (cur.right != null) queue.add(cur.right);
		}
	}
	
	// 找出最小值
	public E minimum() {
		if (isEmpty()) throw new IllegalArgumentException("Minimum failed, Binary tree is empty.");
		return minimum(this.root).val;
	}
	
	private Node minimum(Node node) {
		if (node.left == null) return node;
		return minimum(node.left);
	}
	
	// 找出最大值
	public E maximum() {
		if (isEmpty()) throw new IllegalArgumentException("Minimum failed, Binary tree is empty.");
		return maximum(this.root).val;
	}
	
	private Node maximum(Node node) {
		if (node.right == null) return node;
		return maximum(node.right);
	}
	
	// 刪除最小值
	public E removeMin() {
		E min = minimum();
		this.root = removeMin(this.root);
		return min;
	}
	
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	
	// 刪除最大值
	public E removeMax() {
		E max = maximum();
		this.root = removeMax(this.root);
		return max;
	}
	
	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}
	
	// 刪除值
	public void remove(E val) {
		this.root = remove(this.root, val);
	}
	
	private Node remove(Node node, E val) {
		if (node == null) return node;
		
		if (val.compareTo(node.val) < 0) {
			node.left = remove(node.left, val);
			return node;
		} else if (val.compareTo(node.val) > 0) {
			node.right = remove(node.right, val);
			return node;
		}  else { // val == node.val
			
			if (node.left == null) {
				
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}
			
			if (node.right == null) {
				
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}
			
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;
			
			node.left = node.right = null;
			return successor;
		}
	}
	
	// 找到比 val 小的最大值
	public E floor(E val) {
		if (isEmpty()) throw new IllegalArgumentException("Get floor failed, Binary tree is empty.");
		Node floorNode = floor(this.root, val);
		if (floorNode == null) return val;
		return floorNode.val;
	}
	
	private Node floor(Node node, E val) {
		if (node == null || val == node.val) return node;
		
		if (val.compareTo(node.val) < 0) {
			return floor(node.left, val);
		}
		
		Node floorNode = floor(node.right, val);
		if (floorNode == null) return node;
		return floorNode.val.compareTo(val) <= 0 ? floorNode : node;
	}
	
	
	// 找到比 val 大的最小值
	public E ceil(E val) {
		if (isEmpty()) throw new IllegalArgumentException("Get ceil failed, Binary tree is empty.");
		Node ceilNode = ceil(this.root, val);
		if (ceilNode == null) return val;
		return ceilNode.val;
	}
	
	private Node ceil(Node node,E val) {
		if (node == null || val  == node.val) return node;
		
		
		if (val.compareTo(node.val) > 0) {
			return ceil(node.right, val);
		}
		
		Node ceilNode = ceil(node.left, val);
		if (ceilNode == null) return node;
		
		return ceilNode.val.compareTo(val) >= 0 ? ceilNode : node;
	}
	
}



