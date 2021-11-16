package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.MemberService;

public class testDI {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
		
		// DL(Dependency Lookup)
		MemberService memberService = (MemberService) factory.getBean("memberService");
		System.out.println(memberService.findMemberById("java"));
		
		factory.close();
	}
}
