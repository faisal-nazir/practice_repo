package interview.pro.daily.problem;

public class StringToInteger {

	public static int myAtoi(String str) {
        if(str == null || str.isEmpty()) return 0;
        
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' ') 
            ++i;
        
        if(i == str.length()) return 0;
        
        boolean isNegative = false;
        if(i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if(str.charAt(i) == '-')
                isNegative = true;
            ++i;
        }
        
        boolean digitFound = false;
        if(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9')
            digitFound = true;
        
        if(!digitFound) return 0;
        
        long res = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = (res * 10) + str.charAt(i) - '0';
            ++i;
        }
        
        res = (isNegative)? -res : res;
        
        if(res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        
        if(res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)res;
    }
	
	public static void main(String[] args) {
		String str = "9223372036854775808";
		System.out.print(myAtoi(str));
	}
}
