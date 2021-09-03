package step6;

public class Car {
	//생성자를 명시하지 않으면 public Car(){} 와 같은 기본 생성자를 컴파일시에 자동으로 만들어준다 
	//아래와 같이 생성자를 직접 명시해서 객체 생성시 실제로 호출되는 지 확인해본다 
	//생성자 constructor 명은 클래스명과 동일해야 한다 
	public Car() {
		System.out.println("Car 생성자 호출");
	}//이 생성자가 실행이 완료되면 메모리에 객체가 생성된다 
	
}
