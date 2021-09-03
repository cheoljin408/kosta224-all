package step1;

public class TestStatic4 {
	public static void main(String[] args) {
		// java se api 에서 지원하는 static 사용하기
		String s1 = "1";
		String s2 = "2";
		int i = 3;
		
		System.out.println(s1 + s2 + i); // 123 (문자열 이므로)
		
		// java.lang.Integer class의 static method를 이용해 문자열을 정수로 변환
		int num1 = Integer.parseInt(s1); // 문자열을 정수로 변환
		int num2 = Integer.parseInt(s2);
		System.out.println(num1 + num2 + i);
	}
}
