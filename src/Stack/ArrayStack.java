public class ArrayStack<E> implements Stack<E> {
	
	private Array<E> array;
	
	public ArrayStack(int capacity) {
		this.array = new Array<E>(capacity);
	}
	
	public ArrayStack() {
		this(10);
	}
	
	public int getSize() {
		return array.getSize();
	}
	
	public int getCapacity() {
		return array.getCapacity();
	}
	
	public boolean isEmpty() {
		return array.isEmpty();
	}
	
	public void push(E e) {
		array.addLast(e);
	}
	
	public E pop() {
		return array.removeLast();
	}
	
	public E peek() {
		return array.getLast();
	}
	
	private void resize(int newCapacity) {
		if (newCapacity < 0) throw new IllegalArgumentException("Resize failed, capacity is illegal.");
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		
		res.append(String.format("ArrayStack: size: [ %d ], capacity: [ %d ]\n", array.getSize(), getCapacity()));
		res.append("[ ");
		
		for (int i = 0; i < array.getSize(); i++) {
			res.append(array.get(i));
			if (i != (array.getSize() - 1)) res.append(", ");
		}
		
		res.append(" ] Top");
		return res.toString();
	}
	
}