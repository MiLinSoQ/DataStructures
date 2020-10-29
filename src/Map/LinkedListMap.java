public class LinkedListMap<K, V> implements Map<K, V> {
	
	private class Node {
		private K key;
		private V value;
		public Node next;
		
		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public Node(K key, V value) {
			this(key, value, null);
		}
		
		public Node() {
			this(null, null, null);
		}
		
		@Override
		public String toString() {
			if (key == null || value == null) return "";
			return this.key.toString() + " : " + this.value.toString();
		}
	}
	
	private Node dummyNode;
	private int size;
	
	public LinkedListMap() {
		this.dummyNode = new Node();
		this.size = 0;
	}
	
	@Override
	public int getSize() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public V get(K key) {
		Node node = getNode(key);
		return (node == null ? null : node.value);
	}
	
	@Override
	public void set(K key, V newValue) {
		Node node = getNode(key);
		if (node != null) {
			node.value = newValue;
		} else {
			throw new IllegalArgumentException(key + " doesn't exist!");
		}
	}
	
	private Node getNode(K key) {
		Node cur = dummyNode.next;
		while (cur != null) {
			if (cur.key.equals(key)) return cur;
			cur = cur.next;
		}
		return null;
	}
	
	@Override
	public boolean contains(K key) {
		Node node = getNode(key);
		return (node != null);
	}
	
	@Override
	public void add(K key, V value) {
		Node node = getNode(key);
		if (node == null) {
			this.dummyNode.next = new Node(key, value, this.dummyNode.next);
			size++;
		} else {
			node.value = value;
		}
	}
	
	@Override
	public V remove(K key) {
		
		Node prev = this.dummyNode;
        while(prev.next != null){
            if(prev.next.key.equals(key)) break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
	}
}