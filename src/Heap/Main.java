import java.util.Random;

public class Main {
	
	public static void main(String args[]) {
		// testMaxHeap();
		testMaxHeap2();
	}
	
	
	private static void testMaxHeap() {
		
		MaxHeap<Integer> heap = new MaxHeap<>();
		
		System.out.println("size: " + heap.getSize());
		
		heap.add(52);
		heap.add(62);
		heap.add(90);
		heap.add(50);
		heap.add(51);
		heap.add(63);
		System.out.println(heap.toString());
		
		heap.extractMax();
		System.out.println(heap.toString());
		
		heap.extractMax();
		System.out.println(heap.toString());
		
	}
	
	private static void testMaxHeap2() {
		int n = 1000000;
		
		long startTime, endTime;
		
		startTime = System.nanoTime();
		MaxHeap<Integer> heap = new MaxHeap();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			heap.add(random.nextInt(Integer.MAX_VALUE));
		}
		
		
		int[] nums = new int[n];
		for (int i = 0; i < heap.getSize(); i++) {
			nums[i] = heap.extractMax();
		}
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) throw new IllegalArgumentException("Error");
		}
		
		endTime = System.nanoTime();
		System.out.println(String.format("Use time: [ %.2f s]", ((endTime - startTime) / 1000000000.0)));
		// System.out.println(heap.toString());
		
		
	}
	
}