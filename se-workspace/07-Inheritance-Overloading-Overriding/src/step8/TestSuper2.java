package step8;

class GrandParent { // extends Object -> 상속 관계가 없는 클래스는 extends Object가 자동 삽입 된다.
	GrandParent() { // super();가 자동 삽입 -> 모든 자바 클래스의 root or 최상위 클래스인 Object의 생성자를 호출해 Object 객체를 생성
		System.out.println("GrandParent 객체 생성");
	}
}

class Parent extends GrandParent {
	Parent() { // super();가 자동 삽입
		System.out.println("Parent 객체 생성");
	}
}

class Child extends Parent {
	Child() {
		// super(); // 없으면 자동으로 삽입
		System.out.println("Child 객체 생성");
		// super(); // super()는 생성자 안에서 첫 라인에 배치되어야 한다. 아니면 compile error
	}
}

public class TestSuper2 {
	public static void main(String[] args) {
		new Child(); // 자식 객체를 생성하면 부모객체 -> 자식객체 순으로 생성된다.
	}
}
