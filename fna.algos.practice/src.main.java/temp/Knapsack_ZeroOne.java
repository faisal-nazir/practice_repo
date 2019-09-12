package temp;

import java.util.*;

public class Knapsack_ZeroOne {

	static class Item {
		int value;
		int weight;
		
		
		public Item(int value, int weight) {
			super();
			this.value = value;
			this.weight = weight;
		}
		
		private static List<Item> getItems() {
			Item one = new Item(60, 5);
			Item two = new Item(50, 3);
			Item three = new Item(70, 4);
			Item four = new Item(30, 2);
			
			List<Item> items = new ArrayList<>();
			items.add(one);
			items.add(two);
			items.add(three);
			items.add(four);
			
			return items;

		}
	}
	
	public static int sovle_knapsack(List<Item> items, int capacity) {
		int[][] table = new int[items.size()+1][capacity+1];
		
		for(int i = 1; i <= items.size(); ++i) {
			Item currentItem = items.get(i-1);
			for(int j = 1; j <= capacity; ++j) {
				int valueWithOutItem = table[i-1][j];
				int valueWithItem = (j >= currentItem.weight) ? currentItem.value + table[i][j-currentItem.weight] : valueWithOutItem;
				
				table[i][j] = Math.max(valueWithOutItem, valueWithItem);
			}
		}

		return table[items.size()][capacity];		
	}
	
	public static void main(String[] args) {
		List<Item> items = Item.getItems();
		int capacity = 5;
		System.out.print(solveKnapsack_Recur(items, capacity));
	}
	
	
	public static int solveKnapsack_Recur(List<Item> items, int capacity) {
		return solve_Recur(items, 0, capacity);
	}
	
	public static int solve_Recur(List<Item> items, int idx, int capacity) {
		System.out.println("index = " + idx + " , " + "capacity = " + capacity);
		if(idx == items.size()) {
			return 0;
		}
		
//		if(items.get(idx).weight > capacity) return 0;
		
		Item currItem = items.get(idx);
		
		int withItem = (items.get(idx).weight > capacity) ? 0
				: currItem.value + solve_Recur(items, idx + 1, capacity - currItem.weight);
		int withOutItem = solve_Recur(items, idx+1, capacity);
		
		
		return Math.max(withOutItem, withItem);
		
//		return Math.max(currItem.value + solve_Recur(items, idx+1 , capacity-currItem.weight),
//				solve_Recur(items, idx+1, capacity));
	}
	
}
