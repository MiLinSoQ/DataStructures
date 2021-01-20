public class Main {
	
	public static void main(String[] args) {
		
		Integer[] data = {5, 1, 8, 99, 2, 30, 15};
		
		SelectionSort.sort(data);
		
		for (int i = 0; i < data.length; i ++) {
			System.out.print(data[i] + " ");
		}
	}
}