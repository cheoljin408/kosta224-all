package step5;

import java.util.ArrayList;

// Generic을 적용한 List의 예
public class TetsList3 {
	public static void main(String[] args) {
		ArrayList<FriendDTO> list = new ArrayList<FriendDTO>();
		list.add(new FriendDTO("아이유", 100));
		list.add(new FriendDTO("박보검", 200));
		list.add(new FriendDTO("강하늘", 50));
		// list.add("ㅋㅋㅋ"); // Generic에 명시된 타입이 아니므로 error
		
		// list 요소 중 index가 1인 요소의 name을 출력
		// Generic이 적용되었으므로 별도의 casting은 필요없다
		System.out.println(list.get(1).getName());
		
		// for문을 이용해 요소의 getMoney()를 호출해 money를 출력
		// 별도의 캐스팅 작업은 필요 없다
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getMoney());
		}
	}
}
