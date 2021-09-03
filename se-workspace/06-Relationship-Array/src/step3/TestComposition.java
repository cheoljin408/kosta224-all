package step3;

public class TestComposition {
	public static void main(String[] args) {
		Car car = new Car("소나타");
		System.out.println(car.getModel());
		// car 객체의 engine의 type을 반환받아 출력해본다.
		System.out.println(car.getEngine().getType());
		// car 객체의 engine의 displacement를 반환받아 출력해본다.
		System.out.println(car.getEngine().getDisplacement());
		// car 객체의 engine displacement를 2500으로 변경해본다.
		car.getEngine().setDisplacement(2500);
		System.out.println(car.getEngine().getDisplacement());
	}
}
