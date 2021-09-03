package step5.test;

import step5.kosta.service.PotatoPizzaService;
import step5.kosta.service.SeaFoodPizzaService;
import step5.service.PizzaService;

public class TestAbstract3 {
	public static void main(String[] args) {
		PizzaService serviceList[] = {new PotatoPizzaService(), new SeaFoodPizzaService()};
		
		for(int i=0; i<serviceList.length; i++) {
			serviceList[i].makePizza(); // 개별 피자의 모든 작업 공정을 하나의 메소드에서 처리
			System.out.println("********************");
		}
	}
}
