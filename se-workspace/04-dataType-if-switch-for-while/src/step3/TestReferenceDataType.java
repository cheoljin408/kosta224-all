package step3;

public class TestReferenceDataType {
	public static void main(String[] args) {
		// 아래는 생성자 매개변수 parameter 리스트에 알맞는
		// 인자 argument를 전달하지 않았으므로 error
		// Person p = new Person();
		
		Person p; // 선언 Person 참조형 타입, p는 참조변수
		// 생성(heap 영역에 객체 생성, 주소값 반환)
		// p 참조변수에 주소값 할당
		p = new Person("아이유", 100);
		System.out.println(p); // 주소값 확인
		System.out.println(p.getMoney()); // 참조변수로 객체를 제어
		p.setMoney(200);
		System.out.println(p.getMoney());
		System.out.println(p.getName());
		Person p2 = new Person("장기하", 200);
		System.out.println(p2);
		
		// p2 객체의 주소값을 p 참조변수에 할당
		p=p2;
		System.out.println("**예상해보기**");
		System.out.println(p.getName());
		System.out.println(p2.getName());
	}
}
