package org.kosta.model;

import org.springframework.stereotype.Repository;

// 영속성 계층의 bean 생성시 사용하는 어노테이션, spring container는 소문자로 시작하는 클래스명을 bean id로 저장
@Repository
public class MemberDAOImpl implements MemberDAO {
	public void register(String memberInfo) {
		System.out.println(getClass().getName() + " register " + memberInfo);
	}
}
