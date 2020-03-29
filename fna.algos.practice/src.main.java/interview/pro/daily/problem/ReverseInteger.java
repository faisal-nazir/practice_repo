package interview.pro.daily.problem;

public class ReverseInteger {

	// EPI - 5.8
	// https://leetcode.com/problems/reverse-integer/
	public static int reverse_01(int num) {
		boolean isNegative = num < 0;
		long res = 0;
		while(num > 0) {
			res = res * 10 + (num%10);
			num /= 10;
		}
		if(res > Integer.MAX_VALUE) return 0;
		return isNegative ? -(int)res : (int)res;
	}
	
	//https://leetcode.com/problems/reverse-integer/discuss/4056/Very-Short-(7-lines)-and-Elegant-Solution
	
	public int reverse_02(int x) {
        long rev= 0;
        boolean isNegative = x < 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return isNegative ? -(int)rev : (int)rev; 
    }
	
	public int reverse_03(int x) {
        int prevRev = 0 , rev= 0;
        while( x != 0){
            rev= rev*10 + (x % 10);
            if((rev - x % 10) / 10 != prevRev){
                return 0;
            }
            prevRev = rev;
            x= x/10;
        }
        return rev;
    }
		
}
