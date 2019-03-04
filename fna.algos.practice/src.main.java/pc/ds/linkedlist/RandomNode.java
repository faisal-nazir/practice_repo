package pc.ds.linkedlist;

public class RandomNode {
	public int value;
	public RandomNode next;
	public RandomNode random;
	
	public RandomNode() {}
	
	public RandomNode(int val) {
		this.value = val;
	}
	
	public RandomNode(int val, RandomNode next) {
		this.value = val;
		this.next = next;
	}
}
