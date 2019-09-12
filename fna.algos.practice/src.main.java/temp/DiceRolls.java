package temp;
import java.util.List;
import java.util.ArrayList;


public class DiceRolls {
	public static void getDiceRolls(int noOfDice) {
		solve(noOfDice, new ArrayList<Integer>());
	}

	private static void solve(int diceCount, List<Integer> outCome) {
		if(diceCount == 0) {
			print(outCome);
			return;
		}
		for(int i = 1; i < 7; i++) {
			outCome.add(i);
			solve(diceCount-1, outCome);
			outCome.remove(outCome.size()-1);
		}
	}

	private static void print(List<Integer> outCome) {
		System.out.println();
		for(int i : outCome) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		getDiceRolls(3);
	}
}