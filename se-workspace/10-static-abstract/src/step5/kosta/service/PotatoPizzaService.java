package step5.kosta.service;

import step5.service.PizzaService;

public class PotatoPizzaService extends PizzaService {

	@Override
	protected void topping() {
		System.out.println("감자 토핑");
	}
	
	//포테이토 피자는 도우를 치즈를 추가해서 만들겠다
	@Override
	protected void prepare() {
		System.out.println("치즈를 추가하다");
		super.prepare();
	}
	
}
