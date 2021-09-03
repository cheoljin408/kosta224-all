package step5;

import java.util.ArrayList;

// TestList2는 Grnrgic을 적용하지 않았을 때의 예, Generic을 적용한 TestList
public class TetsList2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new FriendDTO("아이유", 100));
		list.add(new FriendDTO("박보검", 200));
		list.add(new FriendDTO("강하늘", 50));
		list.add("ㅋㅋㅋ"); // Generic을 적용하지 않아서 다른 타입의 요소도 추가 가능
		// list 요소중 index가 1인 요소의 name을 출력하고자 한다
		/*
		Object o = list.get(1);
		FriendDTO dto = (FriendDTO)o; // 형변환, Object down casting이 필요
		System.out.println(dto.getName());
		*/
		
		// 아래와 같이 줄여서 쓰면
		FriendDTO dto = (FriendDTO)list.get(1);
		System.out.println(dto.getName());
		
		// for문을 이용해 요소의 getMoney() 호출해서 money를 출력
		for(int i=0; i<list.size(); i++) {
			FriendDTO fd = (FriendDTO)list.get(i);
			System.out.println(fd.getMoney());
		}
	}
}
