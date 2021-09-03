package step1;

public class TestAssociation {
	public static void main(String[] args) {
		String name = "아이유";
		Person p = new Person(name);
		// association 관계(use a 관계)
		p.tour();
		/*
		 * System.out.println(p.getName()); p.setName("코코");
		 * System.out.println(p.getName());
		 */
		/*
		 * String model = "니로EV"; String color = "검정"; RentCar car = new RentCar(model,
		 * color); System.out.println(car.getModel() + " " + car.getColor());
		 */
	}
}
