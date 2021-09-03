package step4;

class Animal {
	int age = 1;
	public void eat() {
		System.out.println("먹다.");
	}
}

class Person extends Animal { // Person은 Animal을 상속받는다.
	public void study() {
		System.out.println("공부하다.");
	}
}

public class TestInheritance1 {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.age); // 상속받았으므로 age 사용 가능
		p.eat(); // 상속
		p.study(); // Person의 독자적 멤버
	}
}
