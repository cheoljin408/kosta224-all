package step1;

public class TestPolymorphism3 {
	public static void main(String[] args) {
		ZooService service = new ZooService();
		service.pass(new Person());
		service.pass(new Dog());
		
		// 아래와 같이 Monkey가 추가된다고 해도
		// 다형성이 지원되므로 Service 클래스 측에
		// 추가 구현이 필요 없다
		service.pass(new Monkey());
	}
}
