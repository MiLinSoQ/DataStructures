import java.util.Random;

public class QuickSort {
	
	private QuickSort() { }
	
	public static <E extends Comparable<E>> void sort(E[] data) {
		sort(data, 0 , data.length - 1);
	}
	
	private static <E extends Comparable<E>> void sort(E[] data, int l, int r) {
		if (l >= r) return;
		int p = partition(data, l, r);
		sort(data, l, p - 1);
		sort(data, p + 1, r);
	}
	
	private static <E extends Comparable<E>> int partition(E[] data, int l, int r) {
		
		int rand = (new Random()).nextInt(r - l + 1) + l;
		swap(data, l, rand);
		
		int pos = l;
		for (int i = l + 1; i <= r; i ++) {
			if (data[i].compareTo(data[l]) < 0) {
				pos ++;
				swap(data, pos, i);
			}
		}
		swap(data, pos, l);
		return pos;
	}
	
	// 第二種 partition 實現。
	// 進行雙向
	public static <E extends Comparable<E>> void sort2way(E[] data) {
		sort2way(data, 0 , data.length - 1);
	}
	
	private static <E extends Comparable<E>> void sort2way(E[] data, int l, int r) {
		if (l >= r) return;
		int p = partition2(data, l, r);
		sort2way(data, l, p - 1);
		sort2way(data, p + 1, r);
	}
	
	private static <E extends Comparable<E>> int partition2(E[] data, int l, int r) {
		
		int rand = (new Random()).nextInt(r - l + 1) + l;
		swap(data, l, rand);
		
		int i = l, j = r;
		while (true) {
			
			while (i <= j && data[i].compareTo(data[l]) < 0) i ++;
			
			while (j >= i && data[j].compareTo(data[l]) > 0) j --;
			
			if (i >= j) break;
			
			swap(data, i, j);
			i ++;
			j --;
		}
		
		swap(data, l, j);
		return j;
	}
	
	
	// 第三種 partition 實現。
	// 進行三向
	public static <E extends Comparable<E>> void sort3way(E[] data) {
		sort3way(data, 0 , data.length - 1);
	}
	
	private static <E extends Comparable<E>> void sort3way(E[] data, int l, int r) {
		if (l >= r) return;
		
		int rand = (new Random()).nextInt(r - l + 1) + l;
		swap(data, l, rand);
		
		int lt = l, i = l + 1, gt = r + 1;
		while (i < gt) {
			
			if (data[i].compareTo(data[l]) < 0) {
				lt ++;
				swap(data, i, lt);
				i ++;
			} else if (data[i].compareTo(data[l]) > 0) {
				gt --;
				swap(data, i, gt);
			} else {
				i ++;
			}
		}
		
		swap(data, l, lt);
		
		sort3way(data, l, lt -1);
		sort3way(data, gt, r);
	}
	
	private static <E> void swap(E[] data, int a, int b) {
		E temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
}