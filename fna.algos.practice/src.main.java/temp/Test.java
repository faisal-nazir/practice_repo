package temp;

public class Test {

	static class Node {
		int val;
		Node left; 
		Node right;
		
		public Node(int val) {
			this.val = val;			
		}
		
	}
	
	public static int countNodes(Node root) {
		if(root == null) return 0;
		int left = countNodes(root.left);
		int right = countNodes(root.right);
		
		return right+left+1;
	}
	
	public static void main(String[] args) {
		System.out.print(countNodes(getTree()));
	}
	
	private static  Node getTree() {
		Node root = new Node(1);
		root.right = new Node(5);
		root.left = new Node(2);
		root.left.right = new Node(3);
		root.left.left = new Node(4);
		return root;
	}
}
