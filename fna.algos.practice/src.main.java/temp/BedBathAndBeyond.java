package temp;

import java.util.*;

public class BedBathAndBeyond {

	public static List<List<String>> getSeqOfValidWords(String input, Set<String> dic) {
		List<List<String>> res = new ArrayList<>();
		List<String> sequence = new ArrayList<>();
		solve(input, sequence, dic, res);
		return res;
	}
	
	public static void solve(String prefix, List<String> soFar, Set<String> dic, List<List<String>> res) {
		if(prefix.length() == 0) {
			if(soFar.size() > 0) 
				print(soFar);
				res.add(new ArrayList<>(soFar));
			return;				
		}
		
		//for(int i = 0; i < prefix.length(); ++i) {
			for(int j = 1; j <= prefix.length(); ++j) {
				String snippet = prefix.substring(0, j);
				System.out.println("snippet = " + snippet + " , " + "remaining = " + prefix);
				if(dic.contains(snippet)) {
					soFar.add(snippet);
					solve(prefix.substring(j), soFar, dic, res);
					soFar.remove(soFar.size()-1);
				}
			}
		//}
			
	}
	
	public static void main(String[] args) {
		String s = "bedbathandbeyond";
		Set<String> dic = getDictonary();
		
//		print(getSeqOfValidWords(s, dic));
		getSeqOfValidWords(s, dic);
	}
	
	private static Set<String> getDictonary() {
		Set<String> dic = new HashSet<>();
		dic.add("bed");
		dic.add("bath");
		dic.add("beyond");
		dic.add("bat");
		dic.add("hand");dic.add("and");
		return dic;
	}
	
//	private static void print(List<List<String>> lists) {
//		for(List<String> list : lists) {
//			for(String s: list) {
//				System.out.print(s + " "); 
//			}
//			System.out.println();
//		}
//	}
	
	private static void print(List<String> list) {
		for (String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
