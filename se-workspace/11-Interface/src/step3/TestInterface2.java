package step3;

import step2.Airplane;
import step2.Bird;
import step2.Flyer;

public class TestInterface2 {
	public static void main(String[] args) {
		// 하나의 객체가 다양한 인터페이스 타입의 변수로 참조될 수 있다
		Flyer f1 = new SuperMan();
		f1.fly();
		
		Fighter f2 = new SuperMan();
		f2.fight();
		
		System.out.println("************************");
		
		Flyer fa[] = {new Airplane(), new Bird(), new SuperMan()};
		// for loop 이용해서
		for(int i=0; i<fa.length; i++) {
			fa[i].fly(); // 어떤 구체적인 객체인지 몰라도 인터페이스의 abstract method만으로 모든 객체를 각자의 방식으로 동작하게 할 수 있다 -> 다형성
		}
		/*
		 	비행기가 날다
		 	새가 날다
		 	수퍼맨이 날다
		 */
	}
}
