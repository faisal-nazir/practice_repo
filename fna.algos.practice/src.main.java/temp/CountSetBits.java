package temp;

public class CountSetBits {
	
	public static int countSetBits(int x) {
		int y = x & ~(x-1);
		int c = 0;
		while(y != 0) {
			++c;
			x^=y;
			y = x & ~(x-1);
		}
		return c;
	}
	
	public static int count(int x) {
		int c = 0;
		while(x != 0) {
			c += x&1;
			x >>= 1;
		}
		return c;
	}
	
	public static int countSetBits_02(int x) {
		int c = 0;
		while(x != 0) {
			x &= (x-1);
			++c;
		}
		return c;
	}
	
	public static void main(String[] args) {
		
	}
	
	public static int propogateRightMostSetBit(int x) {
		int r = x & ~(x-1);
		System.out.println(r);
		int y = x-1;
		System.out.println(y);
		return x|(x-1);
	}
	
	

}
