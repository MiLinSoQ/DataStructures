import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayQueue<Integer> array = new ArrayQueue<Integer>(8);
		
		for (int i = 0; i < array.getCapacity(); i++) {
			array.enqueue(i);
			System.out.println(array.toString());
			
			if (i != 0 && (i % 3) == 0) {
				array.dequeue();
				System.out.println(array.toString());
			}
			
		}
		
		System.out.println(String.format("First: [ %d ]", array.getFirst()));
		
		// array.enqueue(99);
		// System.out.println(array.toString());
		
		// array.addFirst(1);
		// System.out.println(array.toString());
		// array.addFirst(2);
		// System.out.println(array.toString());
		// array.addFirst(3);
		// System.out.println(array.toString());
		
		// array.removeFirst();
		// System.out.println(array.toString());
		// array.removeFirst();
		// System.out.println(array.toString());
		// array.removeFirst();
		// System.out.println(array.toString());
		
		// array.removeLast();
		// System.out.println(array.toString());
		// array.removeLast();
		// System.out.println(array.toString());
		// array.removeLast();
		// System.out.println(array.toString());
		
		// ArrayStack<Integer> array = new ArrayStack<Integer>();
		
		// for (int i = 0; i < array.getCapacity(); i++) {
			// array.push(i);
			// System.out.println(array.toString());
		// }
		
		// array.pop();
		// System.out.println(array.toString());
		
		// System.out.println(String.format("Peek: [ %d ]", array.peek()));
	}
	
}
