package step1;

/*
 	try catch finally 실행 결과 예상
 	정상적인 흐름: money에 100을 할당했을 때, a c 출력
 	예외적인 흐름: money에 백을 할당했을 때, b c 출력
 */
public class TestException6 {
	public static void main(String[] args) {
		String money = "100";
		
		// 예외적인 흐름 테스트를 위해 재할당
		money = "백";
		
		try {
			int im = Integer.parseInt(money);
			System.out.println("a");
		}
		catch(NumberFormatException ne) {
			System.out.println("b");
		}
		finally {
			System.out.println("c");
		}
	}
}
