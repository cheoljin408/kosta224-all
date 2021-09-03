package step3;

class Animal {
	public void eat() {
		System.out.println("먹다");
	}
}

class Person extends Animal {
	// 메소드 오버아리딩: 부모 메소드를 자신에 맞게 재정의
	public void eat() {
		System.out.println("사람이 수저를 사용하다");
		super.eat(); // super keyword
	}
}

class Dog extends Animal {
	// 메소드 오버라이딩
	public void eat() {
		System.out.println("강아지가 혓바닥을 사용하다");
		super.eat();
	}
}

public class TestOverriding1 {
	public static void main(String[] args) {
		Person p = new Person();
		p.eat(); // 오버라이딩 된 자신의 메소드가 실행
		
		Dog d = new Dog();
		d.eat(); // 오버라이딩된 메소드가 실행
	}
}
