package step3;

// abstract class 와 abstract method test
// abstract class는 직접 객체화 될 수 없다
abstract class Animal {
	Animal() {
		System.out.println("Animal 객체 생성");
	}
	
	// abstract method는 구현부가 존재하지 않고 선언만 한다
	// 자식(하위) 클래스에게 구현을 강제한다
	public abstract void eat();
}

// Animal을 상속받으면 Animal의 abstract method를 구현하거나 아니면 자신도 abstract로 선언되어야 한다
class Person extends Animal {
	Person() {
		System.out.println("Person 객체 생성");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("사람이 먹다");
	}
}

public class TestAbstract1 {
	public static void main(String[] args) {
		// abstract class는 실재화 할 수 없다(즉 객체 생성 할 수 없다)
		// Animal a = new Animal();
		
		// 자식 객체 생성시 super()를 이용해서 객체 생성은 된다 -> abstract class는 부모 클래스로서의 역할에 집중
		Animal a = new Person();
		a.eat();
		
	}
}
