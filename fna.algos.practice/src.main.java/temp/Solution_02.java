package temp;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution_02 {

	// (2+1) + (7-5) = 6
	
	// ()
	
//			*
//			
//		/		\
//		+		-
//	/	\		/	\
//	
//2     	1		7		5
	
	
//Operands // 2
//Operator // + 

// 3
	
	public static int exp(String str) {
		if(str == null || str.length() == 0) return -1;
		
		Set<Character> set = new HashSet();
		set.add('+');
		set.add('-');
		set.add('*');
		set.add('/');
		
		Stack<Integer> operands = new Stack();
		Stack<Character> operators = new Stack();
		
		int current = 0;
		for(char c : str.toCharArray()) {
			if( c >= '0' && c <= '9') {
				operands.push(Integer.valueOf(c));
			}
			else if(c == '(') {
				operands.push(current);
				current = 0;
			} else if (set.contains(c)) {
				operators.push(c);
			} else if( c == ')') {
				
				if(!operators.isEmpty()) {
					char op = operators.pop();
					if(op == '+') {
						current += operands.pop();
						current += operands.pop();
						
					} else if(op == '-') {
						current -= operands.pop();
						current -= operands.pop();
					}
					
					operands.push(current);
				}
			}
		}
		
		return current;
	}
	
}
