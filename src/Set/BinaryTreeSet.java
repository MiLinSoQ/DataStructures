public class BinaryTreeSet<E extends Comparable<E>> implements Set<E> {
	
	private BinaryTree<E> tree;
	
	public BinaryTreeSet() {
		this.tree = new BinaryTree<>();
	}
	
	@Override
	public int getSize() {
		return this.tree.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		return this.tree.isEmpty();
	}
	
	@Override
	public boolean contains(E val) {
		return this.tree.contains(val);
	}
	
	@Override
	public void add(E val) {
		this.tree.add(val);
	}
	
	@Override
	public void remove(E val) {
		this.tree.remove(val);
	}
	
	@Override
	public String toString() {
		
		StringBuilder res = new StringBuilder();
		
		res.append(String.format("Binary tree set, size: [ %d ]", this.getSize()));
		res.append(tree.chartTree());
		
		return res.toString();
	}
	
}