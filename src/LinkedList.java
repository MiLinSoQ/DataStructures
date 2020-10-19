public class LinkedList<E> {
	
	private class Node {
		
		// �쵲����
		private E e;
		
		// �����쵲
		private Node next;
		
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this(e, null);
		}
		
		public Node() {
			this(null, null);
		}
	}
	
	// �i�H�Q�ε����Y�`�I�A�� addFirst() & addLast() �޿�Τ@�C
	// private dummyHead = new Node();
	
	private Node head;
	
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) throw new IllegalArgumentException("Get failed, index is illegal.");
		
		Node retNode = this.head;
		
		for (int i = 0; i < index; i++) {
			retNode =retNode.next;
		}
		return retNode.e;
		
	}
	
	public E getFirst() {
		if (isEmpty()) throw new IllegalArgumentException("Get failed, data structure is empty.");
		return this.head.e;
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void add(int index, E e) {
		
		if (index < 0 || index > size) throw new IllegalArgumentException("Add failed, index is illegal.");
		
		Node indexNode = this.head;
		for (int i = 0; i < index - 1; i++) {
			indexNode = indexNode.next;
		}
		
		// Node newNode = new Node(e);
		// newNode.next = indexNode.next;
		// indexNode.next = newNode;
		indexNode.next = new Node(e, indexNode.next);
		size++;
	}
	
	public void addFirst(E e) {
		
		// Node newNode = new Node(e);
		// newNode.next = this.head;
		// this.head = newNode;
		this.head = new Node(e, this.head);
		size++;
	}
	
	public void addLast(E e) {
		
		add(size, e);
		
		// Node indexNode = this.head;
		// for (int i = 0; i < size - 1; i++) {
			// indexNode = indexNode.next;
		// }
		
		// Node newNode = new Node(e);
		// newNode.next = indexNode.next;
		// indexNode.next = newNode;
		// size++;
	}
	
	public E remove(int index) {
		
		if (index < 0 || index >= size) throw new IllegalArgumentException("Remove failed, index is illegal.");
		
		Node indexNode = this.head;
		for (int i = 0; i < index - 1; i++) {
			indexNode = indexNode.next;
		}
		
		Node targetNode = indexNode.next;
		indexNode.next = targetNode.next;
		targetNode.next = null;
		
		size--;
		return targetNode.e;
	}
	
	public E removeFirst() {
		
		E ret = this.head.e;
		
		Node indexNode = this.head;
		this.head = indexNode.next;
		indexNode = null;
		size--;
		return ret;
	}
	
	public E removeLast() {
		//E ret = 0;
		return remove(this.size - 1);
	}
	
	public void removeElement(E e) {
		
		if (isEmpty()) throw new IllegalArgumentException("Remove failed, data structure is empty.");
		
		Node indexNode = this.head;
		Node preNode = null;
		
		while (indexNode != null) {
			if (indexNode.e.equals(e)) break;
			preNode = indexNode;
			indexNode = indexNode.next;
		}
		
		if (preNode == null) {
			removeFirst();
		} else if (indexNode != null) {
			
			preNode.next = indexNode.next;
			indexNode.next = null;
			size--;
		}
	}
	
	// ���j�R���Ȭ� e ���쵲
	public void removeElements(E e) {
		this.head = removeElements(this.head, e);
	}
	
	private Node removeElements(Node indexNode, E e) {
		if (indexNode == null) return indexNode;
		
		Node nextNode = removeElements(indexNode.next, e);
		
		if (indexNode.e.equals(e)) {
			size--;
			return nextNode;
		} else {
			indexNode.next = nextNode;
			return indexNode;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Linked List: size: [ %d ]\n", size));
		res.append("Head  ");
		
		Node indexHead = this.head;
		while(indexHead != null) {
			res.append(indexHead.e + " -> ");
			indexHead = indexHead.next;
		}
		
		res.append("Null ");
		return res.toString();
	}
	
}