package temp;

public class RollingCounterAlgorithm {
	
	// http://blog.sandwormz.com/2010/11/rolling-counter-algorithm-pattern.html

	public static String[] mLabels =
	     {"Nickles", "Dimes", "Quarters", "Dollars"};
	 public static int[] mUnitBases = {5, 10, 25, 100};

	 public static void convertPennies(int pennies) {

	     int mCounterPointer = 0;
	     int[] mRollingCounter = new int[mUnitBases.length];

	     while(mCounterPointer < mRollingCounter.length) {
	         printCurrency(pennies, mRollingCounter);
	         mCounterPointer = 0;
	         while(mCounterPointer < mRollingCounter.length) {
	             mRollingCounter[mCounterPointer]++;

	             if(getValue(mRollingCounter) > pennies) {
	                 mRollingCounter[mCounterPointer] = 0;
	             } else {
	                 break;
	             }
	             mCounterPointer++;
	         }
	     }
	 }

	 public static int getValue(int[] currency) {
	     int mTotalValue = 0;
	     for(int i = 0; i < currency.length; i++) {
	         mTotalValue += currency[i] * mUnitBases[i];
	     }
	     return mTotalValue;
	 }

	 private static void printCurrency(int pennies, int[] currency) {
	     for(int i = 0; i < currency.length; i++) {
	         System.out.print(String.valueOf(currency[i]));
	         System.out.print(" " + mLabels[i] + " ");
	     }
	     System.out.println(" and " +
	         (pennies - getValue(currency)) + " pennies");
	 }
}
