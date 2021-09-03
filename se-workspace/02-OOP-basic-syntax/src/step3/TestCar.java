package step3;

public class TestCar {
	public static void main(String[] args) {
		//Car 객체 생성 
		Car c=new Car();
		//Car 객체의 price 변수에 2000 을 할당 
		c.price=2000;
		System.out.println(c.price);//할당한 Car 객체의 price 속성값을 출력 
		c.model="K5";
		System.out.println(c.model);
		c.go(); // 2000 만원 K5 가다 
	}
}
