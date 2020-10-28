public class Main {
	
	public static void main(String[] args) {
		
		testArrayQueue();
		System.out.println("---------------");
		testLoopQueue();
	}
	
	
	private static void testArrayQueue() {
		ArrayQueue<Integer> aq = new ArrayQueue<>();
		for (int i = 0; i < 10; i++) {
			aq.enqueue(i);
		}
		System.out.println(aq.toString());
		
		aq.dequeue();
		System.out.println(aq.toString());
	}
	
	private static void testLoopQueue() {
		LoopQueue<Integer> lq = new LoopQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			lq.enqueue(i);
		}
		System.out.println(lq.toString());
		
		lq.dequeue();
		System.out.println(lq.toString());
	}
}
