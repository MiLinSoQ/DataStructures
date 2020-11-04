public class MaxHeap<E extends Comparable<E>> {
	
	
	private Array<E> array;
	
	
	public MaxHeap(int capacity) {
		this.array = new Array(capacity);
	}
	
	public MaxHeap() {
		this(10);
	}
	
	public int getSize() {
		return this.array.getSize();
	}
	
	public boolean isEmpty() {
		return this.array.isEmpty();
	}
	
	// 取得父親節點的 index
	private int parent(int index) {
		if (index == 0) throw new IllegalArgumentException("index-0 doesn't hava parent.");
		return (index - 1) / 2;
	}
	
	// 取得左邊節點的 index
	private int leftChild(int index) {
		return index * 2 + 1;
	}
	
	// 取得右邊節點的 index
	private int rightChild(int index) {
		return index * 2 + 2;
	}
	
	// 新增一個元素
	public void add(E value) {
		this.array.addLast(value);
		siftUp(getSize() - 1);
	}
	
	private void siftUp(int index) {
		
		// 如果當前位置的元素比父親節點的元素還要大的話就進入迴圈，進行交換。
		while (index > 0 && this.array.get(index).compareTo(this.array.get(parent(index))) > 0) {
			this.array.swap(index, parent(index));
			index = parent(index);
		}
	}
	
	public E findMax() {
		if (isEmpty()) throw new IllegalArgumentException("Can not findMax when heap is empty.");
		return this.array.get(0);
	}
	
	public E extractMax() {
		E ret = findMax();
		
		this.array.swap(0, getSize() - 1);
		this.array.removeLast();
		siftDown(0);
		
		return ret;
	}
	
	private void siftDown(int index) {
		while (leftChild(index) < getSize()) {
			
			int j = leftChild(index);
			
			if (rightChild(index) < getSize() && this.array.get(rightChild(index)).compareTo(this.array.get(j)) > 0) {
				// j = rightChild(index);
				j ++;
			}
			
			// 當前的元素比左右節點都大，表示不需要繼續往下，直接跳出迴圈。
			if (this.array.get(index).compareTo(this.array.get(j)) >= 0) break;
			
			this.array.swap(index, j);
			index = j;
		}
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder res = new StringBuilder();
		res.append(String.format("Max Heap -> size: [ %d ].\n", getSize()));
		
		for (int i = 0; i < getSize(); i++) {
			res.append(this.array.get(i));
			
			if (i ==  (getSize() - 1)) {
				res.append("\n");
			} else {
				res.append(", ");
			}
		}
		
		return res.toString();
	}
	
}