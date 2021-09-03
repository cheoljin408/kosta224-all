package step2;

public class Bird implements Flyer {
	// 인터페이스에 명시된 추상 메소드는 반드시 구현해야 한다
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("새가 날다");
	}

}
