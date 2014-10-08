public class SuffixTree {
	
	SuffixTreeNode root = new SuffixTreeNode();
	
	public SuffixTree(String s){
		for(int i = 0; i < s.length(); i++){
			String suffix = s.substring(i);
			root.insertString(suffix, i);
		}
	}
	
	public ArrayList<Integer> search(String s){
		return root.search(s);
	}
	
	public static void main(String args[]){
		String str = "bibs";
		SuffixTree tree = new SuffixTree(str);
	}
	
}
