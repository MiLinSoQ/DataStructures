import java.util.*;

public class Array<E> {
	
	private E[] data;
	private int size;
	
	public Array(int capacity) {
		this.data = (E[]) new Object[capacity];
		this.size = 0;
	}
	
	public Array() {
		this(10);
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) throw new IllegalArgumentException("Get failed, index is illegal.");
		return data[index];
	}
	
	public E getFirst() {
		if (isEmpty()) throw new IllegalArgumentException("Get first failed, array is empty.");
		return data[0];
	}
	
	public E getLast() {
		if (isEmpty()) throw new IllegalArgumentException("Get last failed, array is empty.");
		return data[size - 1];
	}
	
	public void set(int index, E e) {
		if (index < 0 || index >= size) throw new IllegalArgumentException("Set failed, index is illegal.");
		data[index] = e;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void add(int index, E e) {
		if (index < 0 || index > size) throw new IllegalArgumentException("Add failed, index is illegal.");
		
		if (size == data.length) resize( 2 * data.length);
		
		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}
		
		data[index] = e;
		size++;
	}
	
	public void addFirst(E e) {
		this.add(0, e);
	}
	
	public void addLast(E e) {
		this.add(size, e);
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) throw new IllegalArgumentException("Remove failed, index is illegal.");
		
		E ret = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		
		size--;
		data[size] = null;
		
		if (size <= data.length / 4 && data.length / 2 != 0) resize(data.length / 2);
		return ret;
	}
	
	public E removeFirst() {
		return this.remove(0);
	}
	
	public E removeLast() {
		return this.remove(size - 1);
	}
	
	private void resize(int capacity) {
		if (capacity < 0) throw new IllegalArgumentException("Resize failed, capacity is illegal.");
		
		E[] newData = (E[]) new Object[capacity];
		
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		
		this.data = newData;
	}
	
	public boolean contains(E e) {
		return (this.find(e) != -1);
	}
	
	public int find(E e) {
		// if (size == 0) throw new IllegalArgumentException("Find failed, size = 0.")
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) return i;
		}
		return -1;
	}
	
	public void clear() {
		data = (E[]) new Object[getCapacity()];
	}
	
	public void reverse() {
		if (isEmpty()) throw new IllegalArgumentException("Reverse failed, array is empty");
		// for (int i = 0; int j = size - 1; i < j; i++; j--) {
			// this.swap(i, j);
		// }
		
		for (int i = 0; i < size / 2; i++) {
			this.swap(i, (size - 1 - i));
		}
		
	}
	
	public void swap(int indexA, int indexB) {
		if (indexA < 0 || indexA >= size || indexB < 0 || indexB >= size) 
			throw new IllegalArgumentException("Swap fail, insex is illegal.");
		
		E tmp = data[indexA];
		data[indexA] = data[indexB];
		data[indexB] = tmp;
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size: [ %d ], capacity: [ %d ]\n", size, getCapacity()));
		res.append("[");
		
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) res.append(", ");
		}
		res.append(" ]");
		
		return res.toString();
	}
	
}