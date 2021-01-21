public class Main {
	
	public static void main(String[] args) {
		
		// System.out.println("Hi");
		
		Integer[] data = {4, 6, 5, 2, 3, 8, 7, 1};
		
		QuickSort.sort3way(data);
		
		
		for (int i : data) {
			System.out.print(i + " ");
		}
		
	}
	
}