public interface Set<E> {
	int getSize();
	boolean isEmpty();
	boolean contains(E val);
	void add(E val);
	void remove(E val);
}