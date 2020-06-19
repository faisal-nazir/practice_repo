package interview.pro.daily.problem;

public class IsPowerOfThree {

	public static boolean isPowerOfThree(int n) {
        boolean res = true;
        while(n > 0) {
            if(n % 3 > 0) return false;
            n /= 3;
        }
        return res;
    }
	
	public static void main(String[] args) {
		int n = 27;
		System.out.print(isPowerOfThree(n));
	}
}
