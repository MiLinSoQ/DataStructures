import java.util.Arrays;

public class MergeSort {
	
	private MergeSort() { };
	
	public static <E extends Comparable<E>> void sort(E[] data) {
		E[] temp = Arrays.copyOf(data, data.length);
		sort(data, 0, data.length - 1, temp);
	}
	
	private static <E extends Comparable<E>> void sort(E[] data, int l, int r, E[] temp) {
		if (l >= r) return;
		
		int mid = l + (r - l) / 2;
		
		sort(data, l, mid, temp);
		sort(data, mid + 1, r, temp);
		
		if (data[mid].compareTo(data[mid + 1]) > 0) {
			merge(data, l, mid, r, temp);
		}
	}
	
	// 
	private static <E extends Comparable<E>> void merge(E[] data, int l, int mid, int r, E[] temp) {
		// E[] temp = Arrays.copyOfRange(data, l, r + 1);
		
		System.arraycopy(data, l, temp, l, r - l + 1);
		
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k ++) {
			if (i > mid) {
				data[k] = temp[j];
				j ++;
			} else if (j > r) {
				data[k] = temp[i];
				i ++;
			} else if (temp[i].compareTo(temp[j]) <= 0) {
				data[k] = temp[i];
				i ++;
			} else {
				data[k] = temp[j];
				j ++;
			}
		}
	}
}