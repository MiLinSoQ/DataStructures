import java.util.TreeMap;

public class Trie {
	
	private class Node {
		public boolean isWord;
		public TreeMap<Character, Node> next;
		
		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<>();
		}
		
		public Node() {
			this(false);
		}
	}
	
	private Node root;
	private int size;
	
	public Trie() {
		this.root = new Node();
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void add(String word) {
		Node cur = this.root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		
		if (!cur.isWord) {
			cur.isWord = true;
			size ++;
		}
	}
	
	public boolean contains(String word) {
		Node cur = this.root;
		for (int i = 0; i < word.length(); i ++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) return false;
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}
	
	public boolean isPrefix(String prefix) {
		
		Node cur = this.root;
		for (int i = 0; i < prefix.length(); i ++) {
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null) return false;
			cur = cur.next.get(c);
		}
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Trie -> size: [ %d ]", this.size));
		
		return res.toString();
	}
}