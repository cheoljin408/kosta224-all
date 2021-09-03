package step6;

// ArrayList 연습 예제
public class TestShoppingCart {
	public static void main(String[] args) {
		ShoppingCartService service = new ShoppingCartService();
		
		// ShoppingCartService class의 instance vaiable로 ArrayList가 있다
		service.addProduct(new ProductVO("테라", "진로", 2000)); // list에 추가
		service.addProduct(new ProductVO("참이슬후레쉬", "진로", 1100)); // list에 추가
		service.addProduct(new ProductVO("유동골뱅이", "유동", 6000)); // list에 추가
		service.printAll(); // 현재 장바구니에 있는 상품이 추가 순서대로 모두 출력된다
		
		int totalPrice = service.getCartTotalPrice();
		System.out.println("상품 총액:" + totalPrice); // 9100
	}
}
