package test;

import java.util.List;

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
		
		ProductVO paramVO = new ProductVO();
		paramVO.setMaker("애플");
		paramVO.setPrice(30);
		
		// 애플 maker의 price가 30을 초과하는 상품 리스트를 product_no desc 내림차순으로 조회
		List<ProductVO> list = m.findProductListByMakerAndPrice(paramVO);
		for(ProductVO vo:list) {
			System.out.println(vo);
		}
		
		ctx.close();
	}
}
