package step7;

import step4.Animal;
import step4.Monkey;
import step4.Person;
import step4.Tiger;

public class TestPolymorphism8 {
	public static void main(String[] args) {
		CompanyService service = new CompanyService();
		Animal ani[] = {new Monkey(), new Tiger(), new Person()};
		service.playAll(ani);
		/*
		 	원숭이가 나무타며 놀다
		 	호랑이가 사냥하며 놀다
		 	사람이 티켓을 구매하다
		 	사람이 데이트하며 놀다
		 */
	}
}
