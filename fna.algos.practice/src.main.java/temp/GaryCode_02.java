package temp;

import java.util.*;

public class GaryCode_02 {
	public static List<Integer> getGrayCodes(int num) {
		if(num == 0) {
			return new ArrayList<>(Arrays.asList(0));
		}
		
		List<Integer> subList = getGrayCodes(num-1);
		int leadingOne = 1 << num-1;
		for(int i = subList.size()-1; i >= 0; --i) {
			subList.add(leadingOne | subList.get(i));
		}
		
		return subList;
	}
	
	public static void main(String[] args) {
		int n = 3;
		print(getGrayCodes(n));
	}
	
	private static void print(List<Integer> list) {
		for(int i : list) {
			System.out.print(i + " ");
		}
	}
}
