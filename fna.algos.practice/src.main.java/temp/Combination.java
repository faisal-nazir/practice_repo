package temp;

import java.util.*;

public class Combination {
	// https://leetcode.com/problems/combinations/
	
	static int count = 0;
	
	public static List<List<Integer>> getCombinations(int n, int k) {
		count = 0;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subSet = new ArrayList<>();
		solve(n, k, 1, subSet, res);
		return res;
	}
	
	
	public static void solve(int n, int k, int idx, List<Integer> soFar, List<List<Integer>> res) {
		++count;
		if(soFar.size() == k) {
			res.add(new ArrayList<>(soFar));
			return;
		}
		int spaceLeft = k - soFar.size();
		
		for(int i = idx; i <= n && spaceLeft <= n-i+1; ++i) {
			//if(soFar.size() < k) {
				soFar.add(i);
				solve(n, k, i+1, soFar, res);
				soFar.remove(soFar.size()-1);
				//solve(n, k, idx+1, soFar, res);
			 //}
		}
	}
	
	public static void main(String[] args) {
		int n = 4; int k = 2;
		print(getCombinations(n,k));
		System.out.println(count);
	}
	
	public static void print(List<List<Integer>> lists) {
		for(List<Integer> list : lists) {
			for(Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	// My leetcode submission
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        if(n <=0 || k > n) return result;
        find(n, k, 1, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void find(int n, int k, int idx, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == k) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        for(int i = idx; i <= n; ++i) {
            current.add(i);
            find(n, k, i+1, current, result);
            current.remove(current.size()-1);
        }
    }
}
