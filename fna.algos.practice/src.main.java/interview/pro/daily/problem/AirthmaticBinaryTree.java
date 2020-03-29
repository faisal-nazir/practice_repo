package interview.pro.daily.problem;

public class AirthmaticBinaryTree {

	// [Daily Problem] Arithmetic Binary Tree
	
	private static class Node {
		char value;
		Node left;
		Node right;
		
		Node(char val) {
			value = val;
		}
	}
	
	public static int evaluate(Node root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return Character.getNumericValue(root.value);
		
		int left = evaluate(root.left);
		int right = evaluate(root.right);
			
		return eval(left, right, root.value);
	}
	
	private static int eval(int a, int b, char op) {
		switch(op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Node root = getExpression();
		System.out.print(evaluate(root));
	}
	
	private static Node getExpression() {
		Node n = new Node('*');
		n.left = new Node('+');
		n.right = new Node('+');
		n.left.left = new Node('3');
		n.left.right = new Node('2');
		
		n.right.left = new Node('4');
		n.right.right = new Node('5');
		
		return n;
		
	}
}
