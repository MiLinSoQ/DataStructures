public class Main {
	
	public static void main(String[] args) {
		
		Integer[] data = {100, 20, 1, 50, 30, 90, 88, 96, 52, 15, 16, 7, 40 };
		
		MergeSort.sort(data);
		
		for (int i : data) {
			
			System.out.print(i + " ");
			
		}
		
		
	}
	
}