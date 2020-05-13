package com.epi.hashtables;

import java.util.*;

// EPI - 13.3 Implement an ISBN cache
public class LRUCache {

	LinkedHashMap<Integer, Integer> map;
	
	@SuppressWarnings("serial")
	public LRUCache(final int capacity) {
		map = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> e) {
				return this.size() > capacity;
			}
			
		};
		
	}
	
	public Integer lookup(Integer key) {
		return map.get(key);
	}
	
	public Integer remove(Integer key) {
		return map.remove(key);
	}
	
	public Integer insert(Integer key, Integer value) {
		// we only insert if the key is not present
		Integer returnValue = map.get(key);
		if(!map.containsKey(key)) {
			map.put(key, value);
			return returnValue;
		}
		return null;
	}
	
}
