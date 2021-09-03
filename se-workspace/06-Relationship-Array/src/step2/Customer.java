package step2;

public class Customer {
	private String name;
	/*
	 	aggregation: has a 관계 즉 Customer가 SmartPhone을 가지고 있는 관계
	 */
	private SmartPhone smartPhone;

	public Customer(String name) {
		super();
		this.name = name;
	}
	
	// 리턴값이 스마트폰 객체의 주소값이므로 리턴타입은 클래스명인 SmartPhone이 된다.
	public SmartPhone getSmartPhone() {
		return smartPhone;
	}
	
	// 호출한 측에서 전달한 인자값은 스마트폰 객체의 주소값이고
	// 이를 전달받기 위한 매개변수의 타입은 SmartPhone 객체의
	// 클래스명인 SmartPhone이 된다.
	public void setSmartPhone(SmartPhone smartPhone) {
		this.smartPhone = smartPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
