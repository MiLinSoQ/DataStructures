public class Main {
	public static void main(String args[]) {
		Trie trie = new Trie();
		
		trie.add("test");
		
		
		System.out.println(trie.toString());
		System.out.println(trie.contains("test"));
	}
}