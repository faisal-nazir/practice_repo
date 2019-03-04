package common.utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MinHeap<T> {
	private List<Node> nodes = new ArrayList<>();
	private Map<T,Integer> position = new HashMap<>();
	
	private boolean hasParent(int index) { return getParentIndex(index) >= 0; }
	private boolean hasLeftChild(int index) { return getLeftChildIndex(index)< nodes.size(); }
	private boolean hasRightChild(int index) { return getRightChildIndex(index) < nodes.size(); }
	
	private int getParentIndex(int index) { return (index - 1) / 2 ; }
	private int getLeftChildIndex(int index) { return (index * 2 ) + 1 ; }
	private int getRightChildIndex(int index) { return (index * 2) + 2 ; }
	
	private Node getParent(int index) { return hasParent(index)? nodes.get(getParentIndex(index)) : null; }
	private Node getLeftChild(int index) { return hasLeftChild(index)? nodes.get(getLeftChildIndex(index)) : null; }
	private Node getRightChild(int index) { return hasRightChild(index)? nodes.get(getRightChildIndex(index)) : null; }
	
	
	public class Node {
		T key;
		int weight;
		
		Node(T item, int w) {
			this.key = item;
			this.weight = w;
		}
	}
	
	public T min() {
		if(isEmpty()) throw new IllegalStateException();
		return nodes.get(0).key;
	}
	
	public T extractMin() {
		if(isEmpty()) throw new IllegalStateException();
		T min = nodes.get(0).key;
		updatePosition(nodes.get(0), nodes.size()-1);
		updatePosition(nodes.get(nodes.size()-1), 0);
		swap(nodes.get(0), nodes.get(nodes.size()-1));
		nodes.remove(nodes.size()-1);
		position.remove(min);
		hepifyDown();
		return min;
	}
	
	public void add(T item, int weight) {
		Node n = new Node(item, weight);
		nodes.add(n);
		position.put(n.key, nodes.size()-1);
		hepifyUp(nodes.size()-1);
	}
	
	public void decrease(T data, int newWeight) {
		int idx = position.get(data);
		Node u = nodes.get(idx);
		if(u.weight <= newWeight) return;
		u.weight = newWeight;
		hepifyUp(idx);
	}
	
	public boolean containsData(T key) {
		return position.containsKey(key);
	}
	
	public Integer getWeight(T key) {
		Integer idx = position.get(key);
        if( idx == null ) {
            return null;
        } else {
            return nodes.get(idx).weight;
        }
    }
	
	private void hepifyUp(int idx) {
		while(hasParent(idx) && getParent(idx).weight > nodes.get(idx).weight) {
			updatePosition(getParent(idx), idx);
			updatePosition(nodes.get(idx), getParentIndex(idx));
			swap(getParent(idx), nodes.get(idx));
			
			idx = getParentIndex(idx);
		}
	}
	
	private void hepifyDown() {
		int idx = 0;
		while(hasLeftChild(idx)) {
			int idx_small = getLeftChildIndex(idx);
			if(hasRightChild(idx)) {
				if(getRightChild(idx).weight < getLeftChild(idx).weight)
					idx_small = getRightChildIndex(idx);
			}
			if(nodes.get(idx_small).weight >= nodes.get(idx).weight)
				break;
			updatePosition(nodes.get(idx_small), idx);
			updatePosition(nodes.get(idx), idx_small);
			swap(nodes.get(idx_small), nodes.get(idx));
			
			idx = idx_small;
		}
	}
	
	private void swap(Node x, Node y) {
		Node temp = new Node(x.key, x.weight);
		x.key = y.key;
		x.weight = y.weight;
		y.key = temp.key;
		y.weight = temp.weight;	
	}
	
	private void updatePosition(Node n, int position) {
		this.position.put(n.key, position);
	}
	
	public boolean isEmpty() {
		return nodes.size() == 0;
	}
	
	public void printHeap(){
        for(Node n : nodes){
            System.out.println(n.weight + " " + n.key);
        }
    }
	
	public void printPositionMap() {
		System.out.print(position);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinHeap<String> heap = new MinHeap<>();
		heap.add("a", 5);
		heap.add("b", 10);
		heap.add("c", 3);
		heap.add("d", 4);
		heap.add("e", 6);
		heap.add("f", 1);
		
		heap.printHeap();
		heap.printPositionMap();
//		System.out.println("Extract Min ->" + heap.extractMin());
//		System.out.println("Decrease Key");
//		heap.decrease("e", 2);
//		System.out.println();
//		heap.printHeap();		
//		heap.printPositionMap();
		System.out.println("Flush heap");
		while(!heap.isEmpty()) {
			System.out.print(heap.getWeight(heap.min()) + ",");
			heap.extractMin();
			System.out.println();
			heap.printHeap();
			heap.printPositionMap();
			System.out.println();
		}
		
	}
}
