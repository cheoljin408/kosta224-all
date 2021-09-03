package step7;

class Person {
	String name = "사람이름";
}

class Student extends Person {
	String name = "학생이름"; // 부모의 인스턴스 변수명과 동일
	
	public void test() {
		System.out.println(name); // 자식의 인스턴스 변수를 출력
		System.out.println(super.name); // super keyword로 부로의 인스턴스 변수에 접근해 출력
	}
}

public class TestSuper1 {
	public static void main(String[] args) {
		Student s = new Student();
		s.test();
	}
}
