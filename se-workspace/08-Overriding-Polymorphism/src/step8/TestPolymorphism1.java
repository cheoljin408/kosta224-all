package step8;

// 다형성이 적용되면 하나의 객체가 여러 타입의 변수로 참조될 수 있다는 것을 확인하는 예제

class Animal {
	public void eat() {
		System.out.println("먹다");
	}
	
	public void sleep() {
		System.out.println("자다");
	}
}

class Person extends Animal {
	// 메소드 오버라이딩
	public void eat() {
		System.out.println("사람이 먹다");
	}
}

public class TestPolymorphism1 {
	public static void main(String[] args) {
		// 일반적으로 아래와 같이 객체를 생성한다
		// Person p = new Person();
		
		// 아래와 같이 부모 타입 Animal의 p 변수로 객체를 참조할 수 있다.
		// -> 아래 코드 라인처럼 부모 타입의 변수로 참조 가능하다는 것이 어떤 장점이 있을까?
		Animal p = new Person();
		
		p.sleep(); // 상속받은 부모 메소드가 실행
		p.eat(); // 자신의 오버라이드한 메소드가 실행
	}
}
