import java.util.Arrays;

public class MergeSort {
	
	private MergeSort() { };
	
	public static <E extends Comparable<E>> void sort(E[] data) {
		sort(data, 0, data.length - 1);
	}
	
	private static <E extends Comparable<E>> void sort(E[] data, int l, int r) {
		if (l >= r) return;
		
		int mid = l + (r - l) / 2;
		
		sort(data, l, mid);
		sort(data, mid + 1, r);
		
		merge(data, l, mid, r);
	}
	
	// 
	private static <E extends Comparable<E>> void merge(E[] data, int l, int mid, int r) {
		E[] temp = Arrays.copyOfRange(data, l, r + 1);
		int i = l, j = mid + 1;
		for (int k = l; k <= r; k ++) {
			if (i > mid) {
				data[k] = temp[j - l];
				j ++;
			} else if (j > r) {
				data[k] = temp[i - l];
				i ++;
			} else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
				data[k] = temp[i - l];
				i ++;
			} else {
				data[k] = temp[j - l];
				j ++;
			}
		}
	}
}