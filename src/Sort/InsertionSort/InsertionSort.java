public class InsertionSort{
	
	private InsertionSort(){ }
	
	public static <E extends Comparable<E>> void sort(E[] data) {
		
		for (int i = 0; i < data.length; i ++) {
			
			E temp = data[i];
			int index = 0;
			for (int j = i; j > 0; j --) {
				if (temp.compareTo(data[j - 1]) < 0) {
					data[j] = data[j - 1];
				} else {
					index = j;
					break;
				}
			}
			data[index] = temp;
		}
	}
	
	private static <E> void swap(E[] data, int a, int b) {
		
		E temp = data[a];
		data[a] = data[b];
		data[b] = temp;
		
	}

}