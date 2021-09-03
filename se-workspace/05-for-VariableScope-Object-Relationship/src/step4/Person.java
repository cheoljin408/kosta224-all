package step4;

public class Person {
	// instance variable
	private String name; // 선언만 해도 기본 초기화, 참조형은 null로 초기화
	private String email; // 선언만 해도 기본 초기화, 참조형은 null로 초기화
	// instance variable
	private int age; // 선언만 해도 기본 초기화, 정수형은 0으로 초기화
	// parameter(매개변수)의 name은
	// local variable
	public Person(String name) {
		this.name = name;
	}
	
	public void eat() {
		// count는 local variable
		int count = 3;
		System.out.println(count + "인분 먹다.");
		
		if(count > 0) {
			int lv = 1;
			System.out.println(lv);
		}
		// 아래 코드는 컴파일 에러, 이유는 local variable은 선언된 영역 내에서만 사용 가능
		// System.out.println(lv);
		
		int lv = 0;
		if(count > 0) {
			lv = 1;
		}
		System.out.println(lv);
	}
	
	public void eat2() {
		// int count; // 지역변수 local variable을 선언만 한다.
		// 아래 코드는 컴파일 에러, local variable은 명시적 초기화를 해야 사용 가능
		// System.out.println(count);
		int count2 = 0;
		System.out.println(count2);
	}
	
	public void testInit() {
		// 인스턴스 변수 초기화를 확인
		System.out.println("name: " + name); // 아이유, 생성자에 의한 초기화
		System.out.println("email: " + email); // null, 기본 초기화
		System.out.println("age: " + age); // 0, 기본 초기화
	}
}
