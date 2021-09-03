package step5.service;

// abstract class: 자신은 직접 객체화 될 수 없고, 부모 클래스로서의 역할에 집중(멤버를 물려주어 재사용성을 높이고 계층구조 형성을 통한 다형성 지원)
public abstract class PizzaService {
	protected void prepare() {
		System.out.println("도우를 만들다");
	}
	
	/*
	 	부모 클래스 차원에서 구현할 수 없는 메소드는 abstract로 선언해서
	 	자식 클래스 차원에서 반드시 구현하게 강제한다
	 */
	protected abstract void topping();
	
	protected void bake() {
		System.out.println("굽다");
	}
	
	protected void cutting() {
		System.out.println("자르다");
	}
	
	protected void boxing() {
		System.out.println("포장하다");
	}
	
	/*
	 	Template Method Design Pattern
	 	작업공정(알고리즘)을 정의해 자식 클래스에게 물려주는 템플릿 메소드
	 */
	public void makePizza() {
		prepare();
		topping(); // 자식 객체의 오버라이딩 된 메소드가 호출
		bake();
		cutting();
		boxing();
	}
}
