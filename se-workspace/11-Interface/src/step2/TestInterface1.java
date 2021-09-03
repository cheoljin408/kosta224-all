package step2;

public class TestInterface1 {
	public static void main(String[] args) {
		// 상수이므로 재할당 불가
		// Flyer.ID = "starjava";
		
		// 사용은 가능
		System.out.println(Flyer.ID);
		
		// 다형성 지원
		// 상위 인터페이스 타입의 변수로 하위 객체 참조할 수 있다
		Flyer f1 = new Bird();
		f1.fly();
		
		Flyer f2 = new Airplane();
		f2.fly();
	}
}
