package step4;

import java.util.ArrayList;

public class TestList1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("김밥"); // 0번 index에 추가
		list.add("햄버거"); // 1번 index에 추가
		list.add("짬뽕"); // 2번 index에 추가
		list.add("김밤"); // 3번 index에 추가
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(2)); // index 요소륿 반환
		System.out.println("삭제: " + list.remove(1)); // index 1의 요소를 삭제
		System.out.println(list);
		
		// for문으로 모든 요소를 출력 -> size()와 get()을 이용
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("수정: " + list.set(2, "피자")); // 출력되는 값은 수정 전 데이터, index 2에 해당하는 요소를 수정
		System.out.println(list); // 수정 후
		list.clear();
		System.out.println(list);
	}
}
