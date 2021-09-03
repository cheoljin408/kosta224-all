package step1;

/*
 	static member는 별도의 객체 생성이 필요없이 클래스 로드만으로 사용가능
 	-> static member 에 접근할 때는 클래스명.멤버(메소드)
 */

class Person {
	int money1; // instance variable: heap 영역에 저장
	static int money2; // static variable: meta space 영역에 저장 -> Class Loading 시점에 메모리에 적재
	
	public void test1() {
		System.out.println("object member method");
	}
	
	public static void test2() {
		System.out.println("static member method");
	}
}

public class TestStatic1 {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.money1); // money1은 instance variable이므로 위 라인과 같이 객체 생성이 필요
		p.test1(); // 객체의 멤버 메소드이므로 참조변수, 메소드로 호출한다
		
		// static member는 별도의 객체 생성 없이 클래스명으로 접근 가능
		System.out.println(Person.money2);
		Person.test2();
	}
}
