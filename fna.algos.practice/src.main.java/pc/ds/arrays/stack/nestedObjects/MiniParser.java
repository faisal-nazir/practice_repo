package pc.ds.arrays.stack.nestedObjects;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MiniParser {
	
	/** Given a nested list of integers represented as a string, implement a parser to deserialize it.

		Each element is either an integer, or a list -- whose elements may also be integers or other lists.
		
		Note: You may assume that the string is well-formed:
		
		String is non-empty.
		String does not contain white spaces.
		String contains only digits 0-9, [, - ,, ].
		
		Example 1:
		Given s = "324",		
		You should return a NestedInteger object which contains a single integer 324.
		
		
		Example 2:
		Given s = "[123,[456,[789]]]",
		
		Return a NestedInteger object containing a nested list with 2 elements:
		
		1. An integer containing value 123.
		2. A nested list containing two elements:
		    i.  An integer containing value 456.
		    ii. A nested list with one element:
		         a. An integer containing value 789.
	**/
	
	public INestedInteger deserialize(String s) {
	    if (s.isEmpty())
	        return null;
	    if (s.charAt(0) != '[') // ERROR: special case
	        return new NestedInteger(Integer.valueOf(s));
	        
	    Deque<INestedInteger> stack = new ArrayDeque<>(); // stack
	    INestedInteger curr = null;
	    int l = 0; // l shall point to the start of a number substring; 
	               // r shall point to the end+1 of a number substring
	    for (int r = 0; r < s.length(); r++) {
	        char ch = s.charAt(r);
	        if (ch == '[') {
	            if (curr != null) {
	                stack.push(curr);
	            }
	            curr = new NestedInteger();
	            l = r+1;
	        } else if (ch == ']') {
	            String num = s.substring(l, r);
	            if (!num.isEmpty())
	                curr.add(new NestedInteger(Integer.valueOf(num)));
	            if (!stack.isEmpty()) {
	                INestedInteger pop = stack.pop();
	                pop.add(curr);
	                curr = pop;
	            }
	            l = r+1;
	        } else if (ch == ',') {
	            if (s.charAt(r-1) != ']') {
	                String num = s.substring(l, r);
	                curr.add(new NestedInteger(Integer.valueOf(num)));
	            }
	            l = r+1;
	        }
	    }
	    
	    return curr;
	}
	
}

