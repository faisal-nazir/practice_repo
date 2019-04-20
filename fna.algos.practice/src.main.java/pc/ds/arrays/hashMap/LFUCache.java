package pc.ds.arrays.hashMap;

import java.util.HashMap;
import java.util.LinkedHashSet;

/** Design and implement a data structure for Least Frequently Used (LFU) cache.
 *  It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), 
the least recently used key would be evicted.

**/

// https://leetcode.com/problems/lfu-cache/discuss/94521/JAVA-O(1)-very-easy-solution-using-3-HashMaps-and-LinkedHashSet
public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists; // linked hash set will preserve the insertion order.
    int cap;
    int min = -1; // [FNA]: keep track of keys with minimum frequency, they will be the first to evict.
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key)) // if the value isn't there then return nothing
            return -1;
        int count = counts.get(key); // value is there, this means it is being accessed for one more time
        counts.put(key, count+1); // therefore increase its count, when you increase the count, the mapping b/w count and its associated set needs to be updated as well.
        lists.get(count).remove(key); // remove it from previously associated count based set.
        if(count==min && lists.get(count).size()==0) // if there is no element with the previous count value,
            min++;									// then no need to track that count set as well.
        if(!lists.containsKey(count+1))	// if the new count is being tracked for the first time
            lists.put(count+1, new LinkedHashSet<Integer>()); // then add a new set to take care of new count value.
        lists.get(count+1).add(key); // add it to the updated count associated set.
        return vals.get(key); // return the value to the user
    }
    
    public void put(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        } 
        if(vals.size() >= cap) {
            int evict = lists.get(min).iterator().next(); // will evict the first element (by insertion order) from the set.
            lists.get(min).remove(evict);
            vals.remove(evict);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}