package com.epi.sorting;

import java.util.*;

public class RemoveFirstNameDuplicates {

	private static class Name implements Comparable<Name> {
		String firstName;
		String lastName;
		
		Name(String f, String l) {
			this.firstName = f;
			this.lastName = l;
		}
		
		public int compareTo(Name other) {
			int comp = firstName.compareTo(other.firstName);
			if(comp != 0) {
				return comp;	
			}
			return lastName.compareTo(other.lastName);
		}
	}
	
	public static void eliminateDuplicates(List<Name> names) {
		Collections.sort(names); 
		int si = 1;
		for(int i = 1; i < names.size(); ++i) {
			if(!names.get(i-1).firstName.equals(names.get(i).firstName)) {
				names.set(si++, names.get(i));
			}
		}
		names.subList(si, names.size()).clear();
	}
	
	public static void main(String[] args) {
		Name a = new Name("Ian", "Davis");
		Name b = new Name("Ian", "Bothom");
		Name c = new Name("David" , "Gower");
		Name d = new Name("Ian", "Bell");
		List<Name> names = new ArrayList<>();
		names.add(a);
		names.add(b);
		names.add(c);
		names.add(d);
		print(names);
		eliminateDuplicates(names);
		print(names);
	}
	
	public static void print(List<Name> names) {
		System.out.println();
		for(Name n : names) {
			System.out.println(n.firstName + ", " + n.lastName);
		}
	}
}
