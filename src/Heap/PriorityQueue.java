public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
	
	private MaxHeap<E> heap;
	
	public PriorityQueue() {
		this.heap = new MaxHeap<>();
	}
	
	@Override
	public int getSize() {
		return this.heap.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return this.heap.isEmpty();
	}
	
	@Override
	public E getFirst() {
		return this.heap.findMax();
	}
	
	@Override
	public void enqueue(E value) {
		this.heap.add(value);
	}
	
	@Override
	public E dequeue() {
		return this.heap.extractMax();
	}
	
	@Override
	public String toString() {
		
		StringBuilder res = new StringBuilder();
		res.append(String.format("Priority Queue -> size: [ %d ].\n", getSize()));
		
		
		return res.toString();
	}
}