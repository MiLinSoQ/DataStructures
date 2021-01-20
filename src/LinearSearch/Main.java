public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		Integer[] datas = { 1, 5, 99, 105};
		Integer target = 6;
		
		int result = LinearSearch.search(datas, target);
		System.out.println(String.format("The index is [ %d ]", result));
		
	}
	
}