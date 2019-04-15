package pc.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

/** Design and implement a data structure for Least Recently Used (LRU) cache.
 *  It should support the following operations: get and put.

	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
	
	Follow up:
	Could you do both operations in O(1) time complexity?
	
	Example:
	
	LRUCache cache = new LRUCache( 2 ); // capacity
	
	cache.put(1, 1);
	cache.put(2, 2);
	cache.get(1);       // returns 1
	cache.put(3, 3);    // evicts key 2
	cache.get(2);       // returns -1 (not found)
	cache.put(4, 4);    // evicts key 1
	cache.get(1);       // returns -1 (not found)
	cache.get(3);       // returns 3
	cache.get(4);       // returns 4
**/

// Laiq's old leetcode submission
// for description and reason to use doubley linked list, refer to
// https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-%2B-Double-linked-list-(with-a-touch-of-pseudo-nodes)
public class LRUCache {
    int size;
    int maxCapacity;
    
    Node head;
    Node tail;
    
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    
    public LRUCache(int capacity) {
        maxCapacity = capacity;    
        size = 0;
        head = tail = null;
    }
    
    public int get(int key) {
        final Node value = map.get(key);
        if(value == null)   return -1;
        moveToHead(value);
        return value.getValue();
    }
    
    public void set(int key, int value) {
        Node h = map.get(key);
        if(h == null) {
            h = new Node(key, value);
            if(size < maxCapacity)
                ++size;
            else {
                map.remove(tail.key);
                removeTail();
            }
            
            addToHead(h);
            
        } else {
            h.value = value;
            moveToHead(h);
        }
        
        map.put(key, h);
        
    }
 
    private void addToHead(Node h) {
        
        if(head == null) {
            head = tail = h;
        } else {
            h.next = head;
            head.prev = h;
            h.prev = null;
            head = h;
        }
    }   
    
    private void removeTail() {
        if(tail == null)    return;
        if(head == tail)    {
            head = tail = null;
            return;
        }
        
        tail.prev.next = null;
        tail = tail.prev;
    }
    
    private void moveToHead(Node h) {
        
        if(h == head)   return;
        
        if(h == tail) {
            h.prev.next = null;
            tail = tail.prev;
        } else {
            h.prev.next = h.next;
            h.next.prev = h.prev;
        }
        
        addToHead(h);
    }
    
    static class Node {
        
        int key;
        int value;
        
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }
        
        public int getValue() { return value;}
    }
}
