package step5;

import java.util.ArrayList;

// Generic을 적용한 List를 활용하는 예제
public class TetsList4 {
	public static void main(String[] args) {
		ArrayList<FriendDTO> list = new ArrayList<FriendDTO>();
		list.add(new FriendDTO("아이유", 100));
		list.add(new FriendDTO("박보검", 200));
		list.add(new FriendDTO("강하늘", 50));
		
		// index가 2인 친구의 money를 출력
		System.out.println(list.get(2).getMoney());
		System.out.println("************");
		
		int money = 100; // list의 요소에서 money 이상을 보유한 객체의 name을 모두 출력
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getMoney() >= money) {
				System.out.println(list.get(i).getName());
			}
		}
		System.out.println("************");
		
		String name = "박보검";
		// list의 요소중 name에 일치하는 요소의 money를 출력해본다 -> 200
		for(int i=0; i<list.size(); i++) {
			// 문자열 비교는 equals로 꼭 해야 한다
			if(list.get(i).getName().equals(name)) {
				System.out.println(list.get(i).getMoney());
			}
		}
		System.out.println("************");
		System.out.println(list);
	}
}
