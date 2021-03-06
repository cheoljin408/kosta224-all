package org.kosta.model;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// 비즈니스 계층에 명시하는 어노테이션. Spring Container에 의해 소문자로 시작하는 클래스명을 id로 하는 bean 생성됨
@Service
public class MemberServiceImpl implements MemberService {
	// Dependency Injection: 필드(or 인스턴스변수)를 통한 의존성 주입
	// @Autowired는 스프링 컨테이너에 생성된 bean중에 일치되는 타입의 bean을 주입
	// @Autowired와 @Resource는 타입을 이용해 일치되는 bean을 주입하는 방식으로
	// 하나의 인터페이스를 여러개의 클래스가 구현하는 경우에는 BeanCreationException과 NoUniqueBeanDefinitionException이 발생된다
	// 이런 경우에는 @Autowired에 @Qualifier(bean id)를 추가하거나 @Resource(name=bean id)을 추가 명시하면 된다
	// @Autowired
	// @Qualifier("memnerDAOImpl2")
	@Resource(name = "memberDAOImpl2")
	private MemberDAO memberDAO;
	// Dependency Injection: 생성자를 통한 의존성 주입
	// @Autowired는 스프링 컨테이너에 생성된 bean중에 일치되는 타입의 bean을 주입
	/*
	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
		System.out.println("DI: " + memberDAO);
	}
	*/
	
	@Override
	public void register(String memberInfo) {
		// System.out.println(getClass().getName() + " register ");
		memberDAO.register(memberInfo);
	}
}
