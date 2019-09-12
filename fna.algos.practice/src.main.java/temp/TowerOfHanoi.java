package temp;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class TowerOfHanoi {

	private static int ans = 0;

	public static void countSteps(int noOfRings) {
		List<Deque<Integer>> pegs = new ArrayList<>();
		for(int i = 0; i < 3; ++i) {
			pegs.add(new LinkedList<Integer>());
		}
		for(int i = noOfRings; i >= 1; --i) {
			pegs.get(0).addFirst(i);
		}

		count(pegs, 0, 1, 2, noOfRings);
		System.out.println("The number of steps are : " + ans);
	}

	private static void count(List<Deque<Integer>> pegs, int source, int dest, int buffer, int ringsToMove) {
		if(ringsToMove > 0) {
			count(pegs, source, buffer, dest, ringsToMove-1);
			int currRing = pegs.get(source).removeFirst();
			pegs.get(dest).addFirst(currRing);
			System.out.println("Moving disk: " + currRing + ", from Tower : " + source + " to Tower : " + dest + " using Tower : " + buffer + " as buffer");
			++ans;
			count(pegs, buffer, dest, source, ringsToMove-1);
		}
	}

	public static void main(String[] args) {
		int noOfRings = 3;
		countSteps(noOfRings);

	}

}