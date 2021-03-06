package test;

import org.kosta.model.MemberService;
import org.kosta.model.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation_IOC_DI {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
		// 컴포넌트 계열 어노테이션으로 생성된 bean의 id는 소문자로 시작하는 클래스명
		// MemberDAO memberDAO = (MemberDAO)ctx.getBean("memberDAOImpl");
		// memberDAO.register("아이유 오리");
		MemberService memberService = (MemberService)ctx.getBean("memberServiceImpl");
		memberService.register("아이유 오리");
		System.out.println("********************************************");
		
		ProductService productService = (ProductService)ctx.getBean("productServiceImpl");
		productService.register("새우깡 1000원");
		
		ctx.close();
	}

}
