public class BinaryTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
	
	private class Node {
		public K key;
		public V value;
		public Node left, right;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		@Override
		public String toString() {
			return key.toString() + " : " + value.toString();
		}
	}
	
	private Node root;
	private int size;
	
	
	@Override
	public int getSize() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public boolean contains(K key) {
		Node node = getNode(this.root, key);
		return (node != null);
	}
	
	private Node getNode(Node node, K key) {
		if (node == null) return node;
		if (key.equals(node.key)) return node;
		
		if (key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		} else { // key > node.key
			return getNode(node.right, key);
		}
	}
	
	@Override
	public V get(K key) {
		Node node = getNode(root, key);
		return (node != null ? node.value : null);
	}
	
	@Override
	public void set(K key, V value) {
		Node node = getNode(root, key);
		if (node != null) {
			node.value = value;
		} else {
			throw new IllegalArgumentException(String.format("%s is not exist!", key));
		}
	}
	
	@Override
	public void add(K key, V value) {
		this.root = add(this.root, key, value);
	}
	
	private Node add(Node node, K key, V value) {
		
		if (node == null) {
			size++;
			return new Node(key, value);
		}
		
		if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		} else { // key == node.key
			node.value = value;
		}
		return node;
	}
	
	private Node minimum(Node node) {
		if (node.left == null) return node;
		return minimum(node.left);
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
	
	@Override
	public V remove(K key) {
		Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
	}
	
	private Node remove(Node node, K key) {
		if (node == null) return node;
		
		if ( key.compareTo(node.key) < 0 ) {
            node.left = remove(node.left , key);
            return node;
        } else if(key.compareTo(node.key) > 0 ) {
            node.right = remove(node.right, key);
            return node;
        } else {
			
			if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
			
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
			
            node.left = node.right = null;
            return successor;
		}
		
	}
	
	
}