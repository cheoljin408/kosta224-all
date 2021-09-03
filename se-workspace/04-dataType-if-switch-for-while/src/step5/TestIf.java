package step5;

public class TestIf {
	public static void main(String[] args) {
		// 조건문 if, else if, else
		int age = -16;
		if(age > 19) {// 조건문에서 중괄호는 여러 라인일때 필수적이고 조건문의 실행문이 한 라인이면 생략 가능
			System.out.println(age + "세 성인입니다.");
		}
		else if(age > 0) {
			System.out.println(age + "세 미성년입니다.");
		}
		else {// 0세 이하이면(나머지)
			System.out.println("잘못된 입력값입니다.");
		}
	}
}
