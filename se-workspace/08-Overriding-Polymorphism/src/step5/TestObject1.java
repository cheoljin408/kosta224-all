package step5;

import step4.solution.Employee;

// java.lang.Object 의 method를 사용해보는 예제

class Car { // extends Object
	// Car() { super(); }
}

public class TestObject1 {
	public static void main(String[] args) {
		Car c = new Car();
		System.out.println(c.getClass()); // 상속받은 Object의 getClass() 메소드를 호출해 현 객체가 어떤 클래스로 생성되었는지를 확인
		
		Employee e = new Employee("1", "아이유", 100);
		System.out.println(e.getClass());
	}
}
