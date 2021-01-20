public class Main {
	
	public static void main(String[] args) {
		
		Integer[] data = {5, 1, 8, 19, 10, 12, 11, 18, 2, 30, 13};
		
		InsertionSort.sort(data);
		
		
		for (int i : data) {
			System.out.print(i + " ");
		}
	}
	
}