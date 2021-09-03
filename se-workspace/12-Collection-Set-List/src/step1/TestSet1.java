package step1;

import java.util.LinkedHashSet;

public class TestSet1 {
	public static void main(String[] args) {
		// java.util.set 특징 -> 중복을 인정하지 않는다
		// <String>: Generic -> 자료구조체에 저장할 요소의 타입을 지정
		LinkedHashSet <String> set = new LinkedHashSet <String>();
		set.add("아이유");
		set.add("박보검");
		set.add("아이유");
		// set.add(777); // compile error, Generic으로 <String>을 명시했으므로 다른 타입의 데이터는 저장될 수 없다
		System.out.println(set.size()); // 요소의 수
		System.out.println(set);
		System.out.println(set.toString());
		set.clear();
		System.out.println(set.size());
		System.out.println(set);
		
		System.out.println("*******************");
		
		LinkedHashSet<Integer> set2 = new LinkedHashSet<Integer>();
		set2.add(10);
		set2.add(22);
		set2.add(33);
		set2.add(22);
		set2.add(new Integer(44));
		System.out.println(set2.size());
		System.out.println(set2);
		System.out.println(set2.isEmpty());
		set2.clear();
		System.out.println(set2.isEmpty());
	}
}
