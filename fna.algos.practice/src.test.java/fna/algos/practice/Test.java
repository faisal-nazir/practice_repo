package fna.algos.practice;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test {

	private static class Node<T> {
		T key;
		int w;
		
		Node(T k, int w) {
			this.key = k;
			this.w = w;
		}

//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((key == null) ? 0 : key.hashCode());
//			return result;
//		}
//
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			Node other = (Node) obj;
//			if (key == null) {
//				if (other.key != null)
//					return false;
//			} else if (!key.equals(other.key))
//				return false;
//			return true;
//		}
	}
	
	public static void main(String[] args) {
		HashMap<Node<String>, Integer> map = new HashMap<>();
		Node<String> a = new Test.Node<>("a", 5); 
		map.put(a, 5);
		map.put(new Test.Node<>("b", 10), 3);
		map.put(new Test.Node<>("c", 3), 2);
		map.put(new Test.Node<>("d", 4), 1);
		map.put(new Test.Node<>("e", 4), 4);
		map.put(new Test.Node<>("f", 1), 0);
		
		
		for(Entry<Node<String>, Integer> e : map.entrySet()) {
			System.out.println(e.getKey().key + "," + e.getValue());
		}
		
		System.out.println(map.get(a));
		
	}
}
