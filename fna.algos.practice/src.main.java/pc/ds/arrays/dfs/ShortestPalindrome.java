package pc.ds.arrays.dfs;

public class ShortestPalindrome {

	/** Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

		For example, given "aacecaaa", return "aaacecaaa"; given "abcd", return "dcbabcd
	 **/
	
	public static String shortestPalindrome_01(String s) {
	    int i=0; 
	    int j=s.length()-1;
	 
	    while(j>=0){
	        if(s.charAt(i)==s.charAt(j)){ //see what characters you can match forming a palindrome
	            i++;
	        }
	        j--;
	    }
	 
	    if(i==s.length())
	        return s;
	 
	    String suffix = s.substring(i); // 
	    String prefix = new StringBuilder(suffix).reverse().toString();
	    String mid = shortestPalindrome_01(s.substring(0, i));
	    return prefix+mid+suffix;
	}
	
	public static void main(String[] args) {
		String s = "aacecaadab";
//		String s = "abcd";
		System.out.println(shortestPalindrome_01(s));
	}
	
	public static String shortestPalindrome_02(String s) {
		if (s == null || s.length() <= 1)
			return s;
	 
		String result = null;
	 
		int len = s.length();
		int mid = len / 2;	
	 
		for (int i = mid; i >= 1; i--) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				if ((result = scanFromCenter(s, i - 1, i)) != null)
					return result;
			} else {
				if ((result = scanFromCenter(s, i - 1, i - 1)) != null)
					return result;
			}
		}
	 
		return result;
	}
	 
	private static String scanFromCenter(String s, int l, int r) {
		int i = 1;
	 
		//scan from center to both sides
		for (; l - i >= 0; i++) {
			if (s.charAt(l - i) != s.charAt(r + i))
				break;
		}
	 
		//if not end at the beginning of s, return null 
		if (l - i >= 0)
			return null;
	 
		StringBuilder sb = new StringBuilder(s.substring(r + i));
		sb.reverse();
	 
		return sb.append(s).toString();
	}
}
