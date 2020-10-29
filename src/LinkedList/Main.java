public class Main {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<>();
		
		// ll.addFirst(5);
		for (int i = 0; i < 5; i++) {
			ll.addFirst(i);
		}
		System.out.println(ll.toString());
		
		ll.add(3, 99);
		System.out.println(ll.toString());
		
		ll.removeLast();
		System.out.println(ll.toString());
		
		System.out.println("Is contains 99: " + ll.contains(99));
		System.out.println("Is contains -99: " + ll.contains(-99));
		System.out.println("Is contains 1: " + ll.contains(1));
	}
}
