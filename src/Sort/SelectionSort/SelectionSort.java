public class SelectionSort {
	
	private SelectionSort() {};
	
	public static <E extends Comparable<E>> void sort(E[] data) {
		
		
		for (int i = 0; i < data.length; i ++) {
			int minIndex = i;	
			for (int j = i; j < data.length; j ++) {
				if (data[j].compareTo(data[minIndex]) < 0) {
					minIndex = j;
				}
			}
			swap(data, i, minIndex);
		}
	}
	
	private static <E> void swap(E[] data, int a, int b) {
		E temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
}