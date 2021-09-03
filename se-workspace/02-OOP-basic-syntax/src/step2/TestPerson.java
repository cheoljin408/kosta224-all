package step2;
/*
 * Person class를 이용해 Person 객체(Object) 를 생성해 변수와 메서드를 테스트하는 목적을 가진 클래스 
 */
public class TestPerson {
	public static void main(String[] args) {
		/* 객체 생성을 위한 코드라인 
		 * Person : 클래스명이고 참조형 데이터 타입이다 
		 * p : 변수 , 참조변수 , 객체를 참조하기 위한 주소값을 저장하는 공간 
		 * = : assign 할당 
		 * new : 객체 생성을 위한 자바 키워드 
		 * Person() : 생성자 constructor 
		 */
		Person p=new Person();
		// 객체의 멤버(속성과 기능)에 접근할 때에는 참조변수.속성 또는 참조변수.메서드()  형식으로 접근해 실행한다 
		System.out.println(p.name);//객체의 속성(변수)에 접근해 값을 출력 
		//객체의 기능 , 메서드를 호출해서 실행 
		p.eat();
		//변수 즉 속성값을 재할당 
		p.name="이강인";
		System.out.println(p.name);
		p.eat();
	}
}













