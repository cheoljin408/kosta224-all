package step2;//패키지: 소문자로 구성 , 디렉토리별로 클래스를 관리  
//클래스 정의 : 대문자로 시작 
/*
 * public : 접근 제어자 access modifier , public 은 어디서나 접근할 수 있는 가장 넓은 범위의 접근제어자 
 * class : class 를 정의할 때 사용하는 자바 키워드(예약어) 
 * Person : 클래스명 
 */
public class Person {
	/*  여러 줄 주석 
	 * 
	 *   인스턴스 변수 : 객체의 속성을 저장하는 공간 
	 *   변수 선언 및 할당 
	 *   String : 데이터 타입, 문자열 데이터를 저장할 때 명시하는 데이터 타입
	 *   name : 변수명 
	 *   = : assign 대입 또는 할당 
	 *   "아이유" : 실제 데이터 
	 */
	String name="아이유";
	/*
	 * 메서드 : 객체의 기능을 정의 
	 * public : 접근제어자 ( 가장 넓은 범위 ) 
	 * void : return 값이 없을 때 명시하는 자바 키워드 
	 */
	public void eat() {
		System.out.println(name+" 점심 먹다");
	}
}
















