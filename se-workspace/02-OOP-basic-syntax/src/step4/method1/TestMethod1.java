package step4.method1;
/*
 * Method 케이스별로  테스트 하는 예제  
 * 1. 매개변수와 리턴값이 없는 경우 
 * 2. 매개변수가 있는 경우 
 * 3. 리턴값이 있는 경우 
 */
public class TestMethod1 {
	//메인메서드 : 프로그램의 시작점 
	public static void main(String[] args) {
		Person p=new Person();//Person 객체 생성 
		p.eat1();//메서드 호출 
		p.eat2("카스");//eat2 메서드의 매개변수parameter에 알맞는 전달인자(argument)를 명시
		p.eat2("치킨");
		//리턴값이 있는 메서드를 호출하여 결과값을 반환받아 출력해본다 
		String result=p.eat3();
		System.out.println("main:"+result);
		//위의 두 라인을 아래와 같이 한라인으로 표현할 수 있다 
		System.out.println("main:"+p.eat3());
	}
}
