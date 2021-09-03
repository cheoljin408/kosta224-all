package step2;

import step1.Animal; // import 단축키 ctrl + shift + o
import step1.Dog;
import step1.Person;

public class ZooService2 {
	public void pass(Animal a) {
		if(a instanceof Person) {
			System.out.println("나는 사람이다");
		}
		else if (a instanceof Dog) {
			System.out.println("나는 개다");
		}
		System.out.println("**is a 관계 테스트**");
		// instanceof 는 is a 관계가 성립된다면 true를 반환
		System.out.println(a instanceof Animal);
	}
}
