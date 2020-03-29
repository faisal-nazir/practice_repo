package com.epi.sorting;

import java.util.*;

// EPI-14.6: COMPUTE THE UNION OF INTERVALS

public class UnionOfIntervals {

	private static class Interval {
		EndPoint start; 
		EndPoint end;
		
		Interval(EndPoint s, EndPoint e) {
			start = s;
			end = e;
		}
	}
	
	private static class EndPoint {
		int value;
		boolean isClosed;
		
		EndPoint(int v, boolean isClosed) {
			this.value = v;
			this.isClosed = isClosed;
		}
	}
	
	public static List<Interval> union(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) return Collections.emptyList();
		List<Interval> res = new ArrayList<>();
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) { 
				int comp = a.start.value - b.start.value;
				if(comp == 0) {
					return (a.start.isClosed && !b.start.isClosed)? -1 : ((b.start.isClosed && !a.start.isClosed) ? 1 : 0);
				}
				return comp;
			}
		});
		res.add(intervals.get(0));
		for(int i = 1; i < intervals.size(); ++i) {
			Interval last_interval = res.get(res.size()-1);
			Interval curr_interval = intervals.get(i);
			if(last_interval.end.value < curr_interval.start.value) {
				res.add(curr_interval);
			} else if (last_interval.end.value == curr_interval.start.value  &&
							curr_interval.start.isClosed) {
				last_interval.end.isClosed = true;
				last_interval.end.value = Math.max(last_interval.end.value, curr_interval.end.value);
			} else if (last_interval.end.value == curr_interval.end.value &&
					curr_interval.start.isClosed) {
				last_interval.end.isClosed = true;
			} 
			else {
				last_interval.end.value = Math.max(last_interval.end.value, curr_interval.end.value);
			}
			
		}
		return res;
	}
	
    public static void main(String[] args) {
    	List<Interval> intervals = getIntervals();
    	List<Interval> res = union(intervals);
    	print(res);

    }
    
    private static void print(List<Interval> list) {
    	for(Interval i : list) {
    		System.out.println("(" + i.start.value + " : " + ((i.start.isClosed)? "CLOSED" : "OPEN") + " , " + 
    							   + i.end.value + " : " + ((i.end.isClosed)? "CLOSED" : "OPEN") + " ) ");
    	}
    }
    
    // Testing data from the EPI
    private static List<Interval> getIntervals() {
    	List<Interval> res = new ArrayList<>();
    	
    	EndPoint e1 = new EndPoint(0, false);
    	EndPoint e2 = new EndPoint(3, false);    	
    	res.add(new Interval(e1, e2));
    	
    	
    	e1 = new EndPoint(1, true);
    	e2 = new EndPoint(1, true);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(2, true);
    	e2 = new EndPoint(4, true);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(3, true);
    	e2 = new EndPoint(4, false);
    	res.add(new Interval(e1, e2));
    	
    	
    	e1 = new EndPoint(5, true);
    	e2 = new EndPoint(7, false);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(9, false);
    	e2 = new EndPoint(11, true);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(12, true);
    	e2 = new EndPoint(14, false);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(7, true);
    	e2 = new EndPoint(8, false);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(12, false);
    	e2 = new EndPoint(16, true);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(8, true);
    	e2 = new EndPoint(11, false);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(13, false);
    	e2 = new EndPoint(15, false);
    	res.add(new Interval(e1, e2));
    	
    	e1 = new EndPoint(16, false);
    	e2 = new EndPoint(17, false);
    	res.add(new Interval(e1, e2));
    	
    	return res;
    }
}
