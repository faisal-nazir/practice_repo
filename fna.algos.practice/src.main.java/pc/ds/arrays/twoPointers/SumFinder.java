package pc.ds.arrays.twoPointers;

import common.utils.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class SumFinder{
	private ArrayList<Integer> numbers = new ArrayList<>();
	private HashMap<Integer, Integer> position = new HashMap<Integer, Integer>();
	private int index = 0;
	
	public void add(int value) {
		numbers.add(value);
		position.put(value, index);
		++index;
	}
	
	public Pair getPairWithSum(int sum) {
		if(numbers == null || numbers.size() < 2) return null;
		for(int first : numbers) {
			int second = sum - first;
			if(position.containsKey(second)) {
				if(position.get(second) == position.get(first))
					continue;
				else return new Pair(position.get(first), position.get(second));
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		SumFinder sf = new SumFinder();
		sf.add(1);
		sf.add(4);
		sf.add(3);
		sf.add(5);
		sf.add(9);
		
		int sum = 14;
		Pair result = sf.getPairWithSum(sum);
		if(result != null)
			System.out.print(result.x + "," + result.y);
		else 
			System.out.print("No pair exists with the sum" + sum);
	}
}
