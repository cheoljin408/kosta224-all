package step3;

import step2.Flyer;

// 여러개의 인터페이스를 implements하여 다양한 계층구조 하에 편입이 가능하다
public class SuperMan implements Flyer, Fighter {

	@Override
	public void fly() {
		System.out.println("수퍼맨이 날다");
	}

	@Override
	public void fight() {
		System.out.println("수퍼맨이 악당과 싸우다");
	}
	
}
