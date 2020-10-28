public class Main {
	
	public static void main(String[] args) {
		
		Array array = new Array(5);
		for (int i = 0; i < 10; i++) {
			array.addLast(i);
			System.out.println(array.toString());
		}
		
		
		array.remove(5);
		System.out.println(array.toString());
		
		array.swap(0, 1);
		System.out.println(array.toString());
		
	}
}
