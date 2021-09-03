package step1;
// Service: 비즈니스 로직을 정의한 클래스(Object)
public class ItemService {
	// 매개변수로 전달된 인자값이 items 배열이므로 데이터 타입은 ItemVO[] 이어야 한다.
	// items 배열 요소 아이템의 name을 모두 출력한다.
	public void printAll(ItemVO [] items) {
		for(int i=0; i<items.length; i++) {
			System.out.println(items[i].getName());
		}
	}

	public void printNameAndPriceByPrice(ItemVO items[], int price) {
		for(int i=0; i<items.length; i++) {
			if(price > items[i].getPrice()) {
				System.out.println(items[i].getName() + " " + items[i].getPrice());
			}
		}
	}
	
}
