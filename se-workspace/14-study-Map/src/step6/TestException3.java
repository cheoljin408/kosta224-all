package step6;

import java.util.ArrayList;

/*
 	case 1
 	프로그램 실행시 Exception 상활 발생되면
 	JVM은 Exception 객체를 생성해 메세지를 콘솔에 출력하고 프로그램 종료시키는 것을 확인하는 예제
 	
 	아래 코드를 실행하면
 	JVM은
 	Exception in thread "main" java.lang.NullPointerException
	at step6.TestException1.main(TestException1.java:13)
	메세지를 콘솔 화면에 출력하고 프로그램은 비정상 종료된다
	
	case 2
	TestException1 상황에서 Exception Handling(예외처리)을 하는 예제
	try와 catch라는 자바 키워드를 이용해 특정 예외 상황이 발생되면 대안흐름을 실행하고
	프로그램은 정상 수행되도록 예외를 처리한다
	try {
		// 예외상황 발생 예상 지점
	} catch(NullPointerException ne) { // 예외가 발생될 때 catch 구문이 실행된다
		// 예외처리하여 대안 흐름을 실행하는 영역
	}
	case1과 case2의 차리는 case2에서 try catch를 이용해 Exception Handling해서
	예외상황 발생 시 프로그램이 비정상 종료되지 않고
	대안 흐름을 실행한 후 프로그램은 정상 수행 되는 데 있다
	
	case 3
	하나의 try블럭 내에 여러개의 Exception이 발생할 수 있다
	이 경우 하나의 try 블럭에 대한 여러 개의 catch 구문이 정의될 수 있다
	Exception catch 대상이 상속 관계에 있으면
	구체적 예외(자식 예외 클래스)에서 추상적 예외(부모 예외 클래스) 순으로
	정의해서 에외를 처리할 수 있다. 즉 
 */
public class TestException3 {
	public static void main(String[] args) {
		String name = "아이유";
		
		// test를 위해 name에 null로 재할당해본다
		// name = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			System.out.println(name.length());
			System.out.println(list.get(0));
		} catch(NullPointerException ne) {
			System.out.println("name 정보가 없으므로 길이를 구할 수 없습니다");
		} catch(IndexOutOfBoundsException ie) {
			System.out.println("리스트의 요소가 존재하지 않아 반환할 수 없습니다");
		} catch(Exception e) { // 자식 -> 부모 순으로 catch 구문을 정의해야 한다
			e.printStackTrace(); // 예외 발생 경로를 모두 출력한다
		}
		System.out.println("프로그램 정상 수행");
	}
}
