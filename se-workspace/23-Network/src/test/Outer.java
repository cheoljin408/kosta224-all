package test;

import java.util.ArrayList;

public class Outer {
	private int money = 100;
	private ArrayList<Inner> list = new ArrayList<Inner>();
	
	public void writeTest() {
		list.add(new Inner());
		list.add(new Inner());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).writer);
		}
	}
	
	public class Inner {
		private String writer = "출력";
		public void test() {
			// Nested (Inner) class는 Outer class의 private member에 직접 접근 가능
			System.out.println(money);
		}
	}
}
