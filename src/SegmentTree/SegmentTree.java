public class SegmentTree<E> {
	
	private E[] tree;
	private E[] data;
	private Merger<E> merger;
	
	public SegmentTree(E[] arr, Merger merger) {
		
		this.merger = merger;
		
		this.data = (E[]) new Object[arr.length];
		
		for (int i = 0; i < arr.length; i ++) {
			this.data[i] = arr[i];
		}
		
		this.tree = (E[]) new Object[4 * arr.length];
		buildSegmentTree(0, 0, this.data.length - 1);
	}
	
	private void buildSegmentTree(int treeIndex, int l, int r) {
		if (l == r) {
			this.tree[treeIndex] = this.data[l];
			return;
		}
		
		int leftIndex = leftChild(treeIndex);
		int rightIndex = rightChild(treeIndex);
		
		
		int mid = l + (r - l) / 2;
		buildSegmentTree(leftIndex, l, mid);
		buildSegmentTree(rightIndex, mid + 1, r);
		
		this.tree[treeIndex] = this.merger.merge(this.tree[leftIndex], this.tree[rightIndex]);
	}
	
	public int getSize() {
		return data.length;
	}
	
	public E get(int index) {
		if (index < 0 || index >= getSize()) throw new IllegalArgumentException("Index is illegal.");
		return this.data[index];
	}
	
	private int leftChild(int index) {
		// if (index < 0 || index >= getSize()) throw new IllegalArgumentException("Index is illegal.");
		return index * 2 + 1;
	}
	
	private int rightChild(int index) {
		// if (index < 0 || index >= getSize()) throw new IllegalArgumentException("Index is illegal.");
		return index * 2 + 2;
	}
	
	public E query(int from, int to) {
		if (from < 0 || from >= this.data.length ||
			to < 0 || to >= this.data.length ||
			from > to) throw new IllegalArgumentException("Index is illegal.");
			
		return query(0, 0, this.data.length - 1, from, to);
	}
	
	public E query(int treeIndex, int l, int r, int from, int to) {
		if (l == from && r == to) return this.tree[treeIndex];
		
		int mid = l + (r - l) / 2;
		int leftIndex = leftChild(treeIndex);
		int rightIndex = rightChild(treeIndex);
		
		if (from >= mid + 1) {
			return query(rightIndex, mid + 1, r, from, to);
		} else if (to <= mid) {
			return query(leftIndex, l, mid, from, to);
		}
		
		E leftResult = query(leftIndex, l, mid, from, mid);
		E rightResult = query(rightIndex, mid + 1, r, mid + 1, to);
		
		return this.merger.merge(leftResult, rightResult);
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		
		res.append("[ ");
		
		for (int i = 0; i < this.tree.length; i ++) {
			if (this.tree[i] != null) {
				res.append(this.tree[i]);
			} else {
				res.append("NULL");
			}
			
			if (i != this.tree.length - 1) {
				res.append(", ");
			} else {
				res.append(" ]");
			}
		}
		return res.toString();
	}
}