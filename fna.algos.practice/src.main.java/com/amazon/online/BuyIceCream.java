package com.amazon.online;

import java.util.HashMap;
import java.util.Map;

/** A queue of people are waiting to buy ice cream from you. 
Each person buys one ice cream, which sells for $5. 
Each customer is holding a bill of $5, $10 or $20. 
Your initial balance is 0. 
Find whether you will be able to make change for every customer in the queue. You must serve customers in the order they come in. 
For example 
5, 5, 5, 10, 20 -> true, 
5, 5, 10 -> true, 
10, 10 -> false
**/
//https://aonecode.com/aplusplus/interviewctrl/getInterview/6410672447442116351
public class BuyIceCream {
	public static boolean sellIcecream(int[] bills) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(5, 0);
		map.put(10, 0);
		map.put(20, 0);
		
		for(int i = 0; i < bills.length; ++i) {
			if(bills[i] == 5)
				map.put(5, map.get(5) + 1);
			else if(bills[i] == 10) {
				if(map.get(5) > 0) {
					map.put(5, map.get(5) - 1);
					map.put(10, map.get(10) + 1);
				}
				else
					return false;
			}
			else if(bills[i] == 20) {
				int n = 15;
				while(map.get(10) > 0 && n >= 10) {
					map.put(10, map.get(10) - 1);
					n-=10;
				}
				while(map.get(5) > 0 && n > 0) {
					map.put(5, map.get(5) - 1);
					n-=5;
				}
				if(n != 0)
					return false;
				map.put(20, map.get(20) + 1);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] bills = {5, 5, 10, 10, 20};
		System.out.println(sellIcecream(bills));
	}
}
