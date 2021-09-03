package step3;

public class TestMap3 {
	public static void main(String[] args) {
		CartService service = new CartService();
		
		service.addProduct(new ProductVO("a", "진라면", "오뚜기", 1200));
		service.addProduct(new ProductVO("b", "짜파게티", "농심", 1400));
		service.addProduct(new ProductVO("c", "비빔면", "팔도", 1300));
		
		// service.printAll();
		String id = "d";
		System.out.println(service.findProductById(id)); // null
		id = "b";
		System.out.println(service.findProductById(id)); // b에 해당하는 상품정보 출력
		
		System.out.println("********삭제 전**********");
		service.printAll();
		service.deleteProductById(id);
		System.out.println("********삭제 후**********");
		service.printAll();
		
		System.out.println("********총 상품 금액**********");
		System.out.println(service.getTotalPrice());
	}
}
