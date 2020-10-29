public class LinkedListSet<E> implements Set<E> {
	
	private LinkedList<E> list;
	
	public LinkedListSet() {
		this.list = new LinkedList<>();
	}
	
	
	@Override
	public int getSize() {
		return this.list.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
	
	@Override
	public boolean contains(E val) {
		return this.list.contains(val);
	}
	
	@Override
	public void add(E val) {
		if (!this.list.contains(val)) {
			this.list.addFirst(val);
		}
	}
	
	@Override
	public void remove(E val) {
		this.list.removeElement(val);
	}
	
	@Override
	public String toString() {
		return this.list.toString();
	}
	
}
	