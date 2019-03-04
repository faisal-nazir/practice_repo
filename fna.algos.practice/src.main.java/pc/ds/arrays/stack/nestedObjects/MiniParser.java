package pc.ds.arrays.stack.nestedObjects;

import java.util.Stack;

public class MiniParser {

	// Given s = "[123,[456,[789]]]",
	
	public INestedInteger deserialize(String s) {
	    if (s.isEmpty())
	        return null;
	    if (s.charAt(0) != '[') // ERROR: special case
	        return new NestedInteger(Integer.valueOf(s));
	        
	    Stack<INestedInteger> stack = new Stack<>();
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

