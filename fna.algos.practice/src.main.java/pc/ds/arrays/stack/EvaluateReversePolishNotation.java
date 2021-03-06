package pc.ds.arrays.stack;

import java.util.ArrayDeque;

public class EvaluateReversePolishNotation {
	
	/** Evaluate the value of an arithmetic expression in Reverse Polish Notation.

		Valid operators are +, -, *, /. Each operand may be an integer or another expression.
		
		Note:
		
		Division between two integers should truncate toward zero.
		The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
		Example 1:
		
		Input: ["2", "1", "+", "3", "*"]
		Output: 9
		Explanation: ((2 + 1) * 3) = 9
		Example 2:
		
		Input: ["4", "13", "5", "/", "+"]
		Output: 6
		Explanation: (4 + (13 / 5)) = 6
		
	**/

	public int evalRPN(String[] tokens) {
        int a,b;
		ArrayDeque<Integer> S = new ArrayDeque<Integer>(); // stack
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}	
		return S.pop();
	}
}
