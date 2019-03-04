package pc.ds.arrays.hashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GroupShiftedStrings {

	/**
	 * Given a string, we can "shift" each of its letter to its successive
	 * letter, for example: "abc" -> "bcd". We can keep "shifting" which forms
	 * the sequence: "abc" -> "bcd" -> ... -> "xyz" Given a list of strings
	 * which contains only lowercase alphabets, group all strings that belong to
	 * the same shifting sequence. For example, given: ["abc", "bcd", "acef",
	 * "xyz", "az", "ba", "a", "z"], Return: [ ["abc","bcd","xyz"], ["az","ba"],
	 * ["acef"], ["a","z"] ] Note: For the return value, each inner list's
	 * elements must follow the lexicographic order.
	 **/

	// https://www.programcreek.com/2014/05/leetcode-group-shifted-strings-java/
	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (String s : strings) {
			char[] arr = s.toCharArray();
			if (arr.length > 0) {
				int diff = arr[0] - 'a';
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] - diff < 'a') {
						arr[i] = (char) (arr[i] - diff + 26);
					} else {
						arr[i] = (char) (arr[i] - diff);
					}

				}
			}

			String ns = new String(arr);
			if (map.containsKey(ns)) {
				map.get(ns).add(s);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(s);
				map.put(ns, al);
			}
		}

		for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
		}

		result.addAll(map.values());

		return result;
	}

	public static void main(String[] args) {
		String[] list = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		List<List<String>> groups = groupStrings_02(list);
		for (List<String> group : groups) {
			System.out.print("[");
			for (String s : group) {
				System.out.print(s + ",");
			}

			System.out.print("]");
			System.out.println();
		}
	}

	// https://www.cnblogs.com/Dylan-Java-NYC/p/5211776.html
	public static List<List<String>> groupStrings_02(String[] strings) {
		if (strings == null || strings.length == 0) {
			return new ArrayList<List<String>>();
		}

		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		for (String str : strings) {
			String base = getBase(str);
			if (!hm.containsKey(base)) {
				List<String> ls = new ArrayList<String>();
				hm.put(base, ls);
			}
			hm.get(base).add(str);
		}

		return new ArrayList<List<String>>(hm.values());
	}

	private static String getBase(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		StringBuilder sb = new StringBuilder();
		int offset = s.charAt(0) - 'a';
		for (int i = 0; i < s.length(); i++) {
			char c = (char) (s.charAt(i) - offset);
			if (c < 'a') {
				c += 26;
			}
			sb.append(c);
		}
		return sb.toString();
	}

}
