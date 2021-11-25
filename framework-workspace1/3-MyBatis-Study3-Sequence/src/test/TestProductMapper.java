package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.model.ProductMapper;
import org.kosta.model.ProductVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProductMapper {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		// Mapper Proxy(Mapper Interface의 구현체)의 bean id는 소문자로 시작하는 인터페이스명이다
		ProductMapper m = (ProductMapper)ctx.getBean("productMapper");
		// System.out.println("총 삼품수: " + m.getTotalProductCount());
		
//		List<String> makerList = m.getMakerKindList();
//		for(String maker:makerList) {
//			System.out.println(maker);
//		}
		
//		ProductVO vo = m.findProductByNo(1);
//		System.out.println("상품검색: " + vo);
		/*
		// 아래와 같이 검색조건 정보가 여러개일때는 vo or map으로 전달한다
		ProductVO paramVO = new ProductVO();
		paramVO.setMaker("애플");
		paramVO.setPrice(30);
		
		// 애플 maker의 price가 30을 초과하는 상품 리스트를 product_no desc 내림차순으로 조회
		List<ProductVO> list = m.findProductListByMakerAndPrice(paramVO);
//		for(ProductVO vo:list) {
//			System.out.println(vo);
//		}
		printList(list);
		*/
		
		// 3. 전달한 price보다 작운 price를 가진 상품정보리스트를 조회
		/*
		int price = 100;
		List<ProductVO> list = m.findProductListLessThanPrice(price);
		printList(list);
		*/
		
		// 4. 가격 구간별 상품리스트 조회
		/*
		int highPrice = 140;
		int lowPrice = 40;
		// java primitive data type에 매칭되는 java.lang 계열 클래스: Wrapper 계열 클래스 Byte, Short, Integer, Long ..
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("HIGHPRICE", highPrice);
		paramMap.put("LOWPRICE", lowPrice);
		printList(m.findProductListByLowPriceAndHighPrice(paramMap));
		*/
		
		// 5. like을 이용한 상품리스트 검색
		/*
		String keyword = "럭";
		printList(m.findProductListLikeKeyword(keyword));
		*/
		
		// 6. sequence 활용, 상품등록
		ProductVO vo = new ProductVO("4분카레", "오뚜기", 1200);
		System.out.println("등록전: " + vo);
		// register() -> registerVer2를 적용하면 등록 후에는 ProductVO에는 발급된 상품번호(시퀀스)가 저장되어 있다
		m.registerVer2(vo);
		System.out.println("등록후: " + vo);
		System.out.println("등록완료");
		printList(m.getAllProductList()); // 상품번호내림차순
		
		ctx.close();
	}
	
	public static void printList(List<ProductVO> list) {
		for(ProductVO vo:list) {
			System.out.println(vo);
		}
	}
}
