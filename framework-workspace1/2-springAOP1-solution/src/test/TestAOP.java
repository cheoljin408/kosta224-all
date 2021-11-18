package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberService;
import model.ProductService;

public class TestAOP {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
		MemberService ms = (MemberService)ctx.getBean("memberService");
		ProductService ps = (ProductService)ctx.getBean("productService");
		
		ms.register("java 아이유 오리");
		System.out.println(ms.findMemberById("spring"));
		ps.deleteProductByNo(1);
		System.out.println(ps.findProductByNo(11));
		System.out.println(ps.findProductListByMaker("LG"));
		
		ctx.close();
	}
}
