

public class Main {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> array = new LinkedList<Integer>();
		
		System.out.println(array.toString());
		
		array.addFirst(5);
		System.out.println(array.toString());
		
		array.addFirst(6);
		System.out.println(array.toString());
		
		array.addFirst(7);
		System.out.println(array.toString());
		
		array.add(1, 99);
		System.out.println(array.toString());
		
		array.addLast(99);
		System.out.println(array.toString());
		
		
		array.removeElements(99);
		System.out.println(array.toString());
		
		// for (int i = 0; i < 10; i++) {
			// array.addFirst(i * 6);
			// System.out.println(array.toString());
			
		// }
		
		// LoopQueue<Integer> array = new LoopQueue<Integer>(4);
		
		// for (int i = 0; i < 5; i++) {
			// array.enqueue(i * 5);
			// System.out.println(array.toString());
		// }
		
		// array.dequeue();
		// System.out.println(array.toString());
	
	}
	
}
