package com.epi.arrays;

import java.util.*;

public class BuyAndSellStockTwice {

	public static double getProfit(List<Double> prices) {
		double maxTotalProfit = 0.0, min_price = Double.MAX_VALUE;
		List<Double> firstBuySellProfits = new ArrayList<Double>();
		
		// Forward phase: For each day, we record the max profit if we sell on that day. 
		for(int i = 0; i < prices.size(); ++i) {
			min_price = Math.min(min_price, prices.get(i));
			maxTotalProfit = Math.max(maxTotalProfit, prices.get(i) - min_price);
			firstBuySellProfits.add(maxTotalProfit);
		}
		
		double max_price = Double.MIN_VALUE;
		for(int i = prices.size()-1; i > 0; i--) {
			max_price = Math.max(max_price, prices.get(i));
			maxTotalProfit = Math.max(maxTotalProfit, max_price - prices.get(i) + firstBuySellProfits.get(i-1));
		}
		
		return maxTotalProfit;
	}
}
