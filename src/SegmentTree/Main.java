public class Main {
	
	public static void main(String args[]) {
		
		Integer[] nums = { 5, 0, -2, 6, 7 };
		
		SegmentTree<Integer> tree = new SegmentTree<>(nums, new Merger<Integer>() {
			@Override
			public Integer merge(Integer a, Integer b) {
				return a + b;
			}
		});
		
		
		System.out.println(tree.toString());
		
		System.out.println("Query: " + tree.query(1, 4));
		System.out.println("Query: " + tree.query(0, 4));
		System.out.println("Query: " + tree.query(3, 4));
		
		tree.set(0, 3);
		System.out.println(tree.toString());
		System.out.println("Query: " + tree.query(0, 4));
	}
	
}