package temp;

public class CountAndSay {

	public static String countAndSay(int n) {
		if(n <= 0) return "";
		String seq = "1"; 
		String temp;
		int count;
		for(int i = 2; i <= n; i++) {
			temp  = "";
			count = 1;
			for(int j = 1; j < seq.length(); ++j) {
				if(seq.charAt(j) == seq.charAt(j-1)) {
					++count;
				}
				else {
					temp += count;
					temp += seq.charAt(j-1);
					count = 1;
				}
			}
			temp += count;
			temp += seq.charAt(seq.length()-1);
			seq = temp;
		}
		return seq;
	}
	
	// 1
	// 11
	// 21
	// 1211
	// 111221
	// 312211
	
	public static void main(String[] args) {
		System.out.println(countAndSay_03(4));
	}
	
	
	// https://leetcode.com/problems/count-and-say/discuss/15995/Examples-of-nth-sequence
	// slick answer from 'yavinci'

	public String countAndSay_02(int n) {
        if(n <= 0) return "-1";
        String result = "1";
        
        for(int i = 1; i < n; i ++) {
            result = build(result);
        }
        return result;
    }
    
    private String build(String result) {
        StringBuilder builder = new StringBuilder();
        int p = 0;
        while(p < result.length()) {
            char val = result.charAt(p);
            int count = 0;
            
            while(p < result.length() && 
              result.charAt(p) == val){
                p ++;
                count ++;
            }
            builder.append(String.valueOf(count));
            builder.append(val);
        }
        return builder.toString();
    }
    
    
    public static String countAndSay_03(int n) {
        if(n == 1) return "1";
        String seq = countAndSay_03(n-1);
        return generateNext(seq);
    }
    
    public static String generateNext(String seq) {
        if(seq == null || seq.isEmpty()) return seq;
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while(i < seq.length()) {
            char c = seq.charAt(i);
            int count = 0;
            while(i < seq.length() && seq.charAt(i) == c) {
            	++count;
                ++i;
            }
            sb.append(c);
            sb.append(String.valueOf(count));   
        }
        
        return sb.toString();
    }
}
