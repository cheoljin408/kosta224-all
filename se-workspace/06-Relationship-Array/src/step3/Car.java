package step3;

public class Car {
	private String model;
	// has a(consist of) -> composition
	private Engine engine;
	/*
	 	Car와 Engine은 긴밀한 composition 관계이므로 life cycle을 함께 한다.
	 	즉, Car 객체 생성시 Engine이 생성되어 인스턴스 변수로 할당되도록 한다.
	 */
	public Car(String model) {
		this.engine = new Engine("터보", 2000); // Car 객체 생성하면 항상 Engine은 만들어진다.
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	
}
