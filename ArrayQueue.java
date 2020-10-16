import java.util.*;

public class ArrayQueue<E> implements Queue<E> {

	private Array<E> array;
	
	public ArrayQueue(int capacity) {
		this.array = new Array<E>(capacity);
	}
	
	public ArrayQueue() {
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
	
	public void enqueue(E e) {
		array.addLast(e);
	}
	
	public E dequeue() {
		return array.removeFirst();
	}
	
	public E getFirst() {
		return array.getFirst();
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array Queue: size: [ %d ], capacity: [ %d ].\n", getSize(), getCapacity()));
		res.append("Head [");
		for (int i = 0; i < getSize(); i++) {
			res.append(array.get(i));
			if (i != (getSize() - 1)) res.append(", ");
		}
		res.append("] Tail");
		return res.toString();
	}

}