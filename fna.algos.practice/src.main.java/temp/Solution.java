package temp;

public class Solution {
	
	// helen.taycher@zoominfo.com
	
	private static final String[] UNITS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
	
	
	public static void main(String[] args) {
		int number = 592;
		System.out.print(getAmount(number));

	}
	
	public static String getAmount(int num) {
		if (num == 0) return "Zero";
		
		String amount = "";
		int position = 0;
		
		while(num > 0) {
			
			if (num % 1000 != 0)
				amount = build(num % 1000) + THOUSANDS[position] + " " + amount;
			
			num /= 1000;
			position++;
		}

		return amount;
				
	}


	private static String build(int num) {
	    if (num == 0)
	        return "";
	    else if (num < 20)
	        return UNITS[num] + " ";
	    else if (num < 100)
	        return TENS[num / 10] + " " + build(num % 10);
	    else
	        return UNITS[num / 100] + " Hundred " + build(num % 100);
	}
	
}
