package step3;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class CartService {
	private LinkedHashMap<String, ProductVO> map = new LinkedHashMap<String, ProductVO>();

	/*
	 	map의 key: ProductVO의 id
	 	map의 value: ProductVO의 객체
	 */
	public void addProduct(ProductVO vo) {
		map.put(vo.getId(), vo);
	}

	/*
	 	map에 저장된 value들만 모두 출력
	 */
	public void printAll() {
		Collection<ProductVO> col = map.values();
		Iterator<ProductVO> it = col.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public ProductVO findProductById(String id) {
		return map.get(id);
	}

	public void deleteProductById(String id) {
		map.remove(id);
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		
		Collection<ProductVO> col = map.values();
		Iterator<ProductVO> it = col.iterator();
		while(it.hasNext()) {
			totalPrice += it.next().getPrice();
		}
		
		return totalPrice;
	}
}
