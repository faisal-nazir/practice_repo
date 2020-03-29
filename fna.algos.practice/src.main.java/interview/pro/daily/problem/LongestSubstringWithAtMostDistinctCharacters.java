package interview.pro.daily.problem;

public class LongestSubstringWithAtMostDistinctCharacters {
	
	public static int compute(String str, int k) {
		int[] map = new int[26];
		int res = 0, i = 0, j=0, distinct = 0;
		while(j < str.length()) {
			if(++map[str.charAt(j++) - 'a'] == 1) ++distinct;
			while(distinct > k) {
				if(--map[str.charAt(i++) - 'a'] == 0) --distinct;
			}
			res = Math.max(res, j-i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String str = "aabcdefff";
		int k = 3;
		System.out.println(compute(str, k));
	}

}
