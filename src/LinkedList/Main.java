public class Main {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<>();
		
		for (int i = 0; i < 5; i++) {
			ll.addFirst(i);
		}
		System.out.println(ll.toString());
		
		ll.add(3, 99);
		System.out.println(ll.toString());
		
		ll.removeLast();
		System.out.println(ll.toString());
		
		
	}
}
