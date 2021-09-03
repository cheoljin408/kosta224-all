package step1;

public class ZooService {
	// 다형성이 지원되므로 다양한 자식 객체들을 
	// 하나의 부모타입 Animal의 매개변수 a로 참조하게 할 수 있다
	public void pass(Animal a) {
		System.out.println();
	}
	// 다형성을 지원 또는 적용하지 않는다면 아래와 같이 객체의 종류별로 메소드를 정의해야 한다
	/*
	 	public void pass(Person p) {}
	 	public void pass(Dog d) {}
	 */
	// 이후 추가적으로 새로운 객체가 전달된다면
	// 다형성을 적용하지 않으면 아래와 같이 메소드가 또 추가되어야 한다
	/*
	 	public void pass(Monkey m) {}
	 */
}
