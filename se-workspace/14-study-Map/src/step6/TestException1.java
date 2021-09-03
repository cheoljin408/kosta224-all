package step6;

/*
 	case 1
 	프로그램 실행시 Exception 상활 발생되면
 	JVM은 Exception 객체를 생성해 메세지를 콘솔에 출력하고 프로그램 종료시키는 것을 확인하는 예제
 	
 	아래 코드를 실행하면
 	JVM은
 	Exception in thread "main" java.lang.NullPointerException
	at step6.TestException1.main(TestException1.java:13)
	메세지를 콘솔 화면에 출력하고 프로그램은 비정상 종료된다
 */
public class TestException1 {
	public static void main(String[] args) {
		String name = "아이유";
		
		// test를 위해 name에 null로 재할당해본다
		name = null;
		System.out.println(name.length());
		System.out.println("프로그램 정상 수행");
	}
}
