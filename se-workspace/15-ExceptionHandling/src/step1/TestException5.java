package step1;

/*
 	finally: 예외 발생 여부와 관계없이 항상 실행
 */
public class TestException5 {
	public static void main(String[] args) {
		String age = "22";
		age = "스물둘";
		System.out.println(age+1); // 문자열이므로 221
		try {
			int iage = Integer.parseInt(age); // 문자열을 정수형으로 변환
			System.out.println(iage+1); // 23 연산되어 합이 출력
		}
		catch(NullPointerException ne) { // NumberFormatException이므로 예외를 처리하지 못한다
			System.out.println("null이므로 데이터를 정상 입력하셔야 합니다");
		}
		finally { // finally 구문은 예외처리 및 발생여부와 관계없이 항상 실행
			System.out.println("finally는 항상 실행");
		}
		System.out.println("프로그램 정상 수행");
	}
}
