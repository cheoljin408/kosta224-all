package step1;

public class Person {
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	 	association 즉 use a 관계는 대상 객체를 사용하는 관계
	 	아래와 같이 대상 객체(RentCar)를 지역변수local variable로 선언, 생성하여
	 	사용하고 메소드가 종료되면 메모리에서 해제되도록 구현한다.
	 */
	public void tour() {
		RentCar car = new RentCar("테슬라", "검정");
		System.out.println(name + " " + car.getColor() +"색 " + car.getModel() + " 렌트카 타고 여행하다.");
	}
}
