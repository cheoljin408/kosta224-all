package step4.method1;

public class Person {
	/*
	 * method case 1 
	 * 매개변수와 리턴값이 없는 메서드 
	 * 호출되면 실행되는 메서드 
	 */
	public void eat1() {
		System.out.println("먹다");
	}
	/*
	 * method case 2 
	 * 매개변수가 정의된 메서드 , 호출한 측에서 데이터(argument:전달인자)를 
	 * 매개변수(parameter)로 전달받는다
	 * 전달받은 매개변수의 데이터를 이용해서 실행한다 
	 */
	public void eat2(String food) {
		System.out.println(food+" 먹다");
	}
	/*
	 * method case 3 
	 * 리턴값이 존재하는 메서드 , 호출한 측으로 메서드 실행 결과를 반환한다
	 * 리턴값이 있을 때는 void 대신 리턴값의 데이터 타입을 명시해야 한다 
	 * 리턴을 명시하는 코드라인은 메서드 마지막 부분에 존재해야 하며 
	 * 메서드 별로 한번만 실행가능하다 
	 */
	public String eat3() {
		System.out.println("eat3 method 실행");
		return "eat3 메서드 실행결과";
	}	  
}



















