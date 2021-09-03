package step5;

import java.util.ArrayList;

class Animal {}

class Person extends Animal {}

class Dog extends Animal {}

public class TestGeneric {
	public static void main(String[] args) {
		// Generic은 is a 관계시에는 요소로 추가 가능
		ArrayList<Animal> list = new ArrayList<Animal>();
		list.add(new Animal());
		list.add(new Person()); // Animal의 자식이므로 가능
		list.add(new Dog()); // Animal의 자식이므로 가능
		// list.add(new Car()); // compile error, Animal 계층 구조하에 있지 않으므로 
	}
}
