package ctci.recursion.dp;

import java.util.Stack;

public class TowersOfHanoi {
	/***
	 * 	Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
		different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
		of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following
		constraints:
		(1) Only one disk can be moved at a time.
		(2) A disk is slid off the top of one tower onto another tower.
		(3) A disk cannot be placed on top of a smaller disk.
		Write a program to move the disks from the first tower to the last using Stacks.
	 */
	
	private Stack<Integer> disks;
	private int index;
	public TowersOfHanoi(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	public int index() {
		return index;
	}
	
	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}
	
	public void moveTopTo(TowersOfHanoi t) {
		int top = disks.pop();
		t.add(top);
	}
	
	public void print() {
		System.out.println("Contents of Tower " + index() + ": " + disks.toString());
	}
	
    public void moveDisks(int n, TowersOfHanoi destination, TowersOfHanoi buffer){
		if (n > 0) {
			String tag = "move_" + n + "_disks_from_" + this.index + "_to_" + destination.index + "_with_buffer_" + buffer.index; 
			System.out.println("<" + tag + ">");
			moveDisks(n - 1, buffer, destination);
			System.out.println("<move_top_from_" + this.index + "_to_" + destination.index + ">");
			System.out.println("<before>");
			System.out.println("<source_print>");
			this.print();
			System.out.println("</source_print>");
			System.out.println("<destination_print>");
			destination.print();
			System.out.println("</destination_print>");
			System.out.println("</before>");
			moveTopTo(destination);
			System.out.println("<after>");
			System.out.println("<source_print>");
			this.print();
			System.out.println("</source_print>");
			System.out.println("<destination_print>");
			destination.print();
			System.out.println("</destination_print>");
			System.out.println("</after>");
			System.out.println("</move_top_from_" + this.index + "_to_" + destination.index + ">");
			buffer.moveDisks(n - 1, destination, this);
			System.out.println("</" + tag + ">");
		}
	}
    
    public static void main(String[] args) {
		// Set up code.
		int n = 3;
		TowersOfHanoi[] towers = new TowersOfHanoi[3];
		for (int i = 0; i < 3; i++) {
			towers[i] = new TowersOfHanoi(i);
		}
		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}
		
		// Copy and paste output into a .XML file and open it with internet explorer.
		//towers[0].print();
		towers[0].moveDisks(n, towers[2], towers[1]);
		//towers[2].print();
	}
}
