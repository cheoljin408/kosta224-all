package step2;

import step1.Dog;
import step1.Monkey;
import step1.Person;

// instanceof 연산자 테스트: is a 관계시 true, 객체의 타입을 비교
public class TestInstanceof {
	public static void main(String[] args) {
		ZooService2 service = new ZooService2();
		service.pass(new Person());
		service.pass(new Dog());
		service.pass(new Monkey());
	}
}
