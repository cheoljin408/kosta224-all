package step1;

class Animal { // extends Object
	int age;
	
	Animal(int age) {
		this.age = age;
	}
}

// Person class가 error가 나는 이유는 기본으로 삽입되는 생성자의 super()는
// 부모의 매개변수가 없는 기본 생성자를 호출하기 때문
// Animal 부모 클래스는 기본 생성자가 존재하지 않으므로 아래 클래스는 compile error가 난다.
// 해결방법은 1. 자식 클래스의 생성자에서 super()를 명시할 때 부오 생성자의 매개변수에 알맞는 인자값을 전달하면 된다.
//		   2. 부모 클래스의 생성자를 오버로딩하여 기본 생성자를 추가한다.
class Person extends Animal {
	String name;
	
	// 아래 생성자는 compile error가 나는 케이스
	/*
	 * Person() { super(); }
	 */
	
	// 생성자를 명시하고 적절한 인자값을 전달하는 super(인자값)를 명시하면 된다.
	Person(int age, String name) {
		super(age); // 반드시 첫라인에 배치되어야 한다.
		this.name = name;
	}
}

public class TestSuper3 {
	public static void main(String[] args) {
		Person p = new Person(22, "아이유"); // Object -> Animal -> Person 순서로 객체 생성
		System.out.println(p.name + " " + p.age);
	}
}
