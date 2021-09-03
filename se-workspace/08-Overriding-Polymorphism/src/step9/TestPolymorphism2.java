package step9;

class Product {
	
}

class Food extends Product {
	
}

class Computer extends Product {
	
}
// ..그 외 여러 상품들이 있다고 가정

class KostaMarket {
	public void pay(Product p) { // 다양한 상품을 부모타입의 변수로 모두 처리가 가능하다
		System.out.println("상품을 결제" + p);
	}
}

public class TestPolymorphism2 {
	public static void main(String[] args) {
		KostaMarket m = new KostaMarket();
		
		// 실제 상품을 전달해서 결제하게 해야한다
		m.pay(new Product());
		m.pay(new Food());
		m.pay(new Computer());
	}
}
