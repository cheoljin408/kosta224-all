package step6;

/*
 	다형성 적용 배열 예제: 부모 타입의 배열객체에 자식 요소 객체를 추가해서 관리할 수 있다
 */

class Car {
	
}

class Animal {
	
}

class Person extends Animal {
	
}

class Dog extends Animal {
	
}

public class TestPolymorphism7 {
	public static void main(String[] args) {
		// 배열 Array는 일반적으로 선언된 타입으로만 요소로 저장이 가능하다
		Animal[] ani1 = new Animal[3];
		ani1[0] = new Animal();
		ani1[1] = new Person(); // 부모 타입의 배열에 자식 객체를 요소로 추가할 수 있다 -> 다형성 적용배열
		// 아래의 Car객체는 Animal과 is a 관계가 아니므로 compile error
		// ani1[2] = new Car();
		ani1[2] = new Dog(); // is a 관계이므로 추가 가능
	}
}
