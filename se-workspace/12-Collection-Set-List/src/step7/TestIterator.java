package step7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestIterator {
	public static void main(String[] args) {
		// Iterator: 반복자, Collection 계열의 모든 자료구조체들이 하나의 단일한 방식으로 요소들을 반복 열거할 수 있도록
		// 			 방법을 제공하는 인터페이스
		
		// 상위 인터페이스 타입으로 참조 가능
		Collection<String> c1 = new LinkedHashSet<String>();
		c1.add("카스");
		c1.add("테라");
		c1.add("한맥");
		Iterator<String> it1 = c1.iterator();
		while(it1.hasNext()) // 다음 요소가 있으면 true
			System.out.println(it1.next()); // 다음 요소를 반환
		System.out.println("****************");
		
		Collection<String> c2 = new ArrayList<String>();
		c2.add("치킨");
		c2.add("골뱅이");
		c2.add("피자");
		Iterator<String> it2 = c2.iterator();
		while(it2.hasNext())
			System.out.println(it2.next());
	}
}
