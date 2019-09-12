package com.epi.arrays;

import java.util.*;

public class BuyAndSellStockOnce {

	public static double getProfit(List<Double> prices) {
		Double min = Double.MAX_VALUE; Double profit = 0.0;
		for(Double price : prices) {
			profit = Math.max(profit, price - min);
			min = Math.min(min, price);
		}
		
		return profit;
	}
}
