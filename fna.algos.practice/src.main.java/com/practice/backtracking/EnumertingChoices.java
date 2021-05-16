package com.practice.backtracking;

public class EnumertingChoices {

	static String indent = "";
	
	public void foo1(int a) {
		if(a <= 0) return;
		enter(a);
		for(int i = 1; i < a; ++i) {
			foo1(i);
		}
		leave(a);
	}
	
	public void foo2(int a) {
		if(a <= 0) return;
		enter(a);
		for(int i = a; i >= 0; --i) {
			foo2(i-1);
		}
		leave(a);
	}
	
	public void foo3(int a) {
		if(a <= 0) return;
		enter(a);
		for(int i = a; i > 0; --i) {
			foo3(a-1);
		}
		leave(a);
	}
	
	public void fooEvenOdd(int a, int even_start, int odd_start, boolean isEven) {
		if(a <= 0) return;
		int start = isEven ? even_start : odd_start;
		enter(a);
		for(int i = start; i < a; i += 2) {
			fooEvenOdd(i, even_start, odd_start, !isEven);
		}
		leave(a);
	}
	
	public static void main(String[] args) {
		indent = "";
		EnumertingChoices c = new EnumertingChoices();
		c.foo1(5);
		//c.fooEvenOdd(10, 2, 1, true);
	}
	
	public static void enter(int a) {
		System.out.println(indent + "Entering foo(" + a + ")");
		indent = indent + "|  ";
	}
	
	public static void leave(int a) {
		indent = indent.substring(3);
		System.out.println(indent + "Leaving foo(" + a + ")");
	}
}
