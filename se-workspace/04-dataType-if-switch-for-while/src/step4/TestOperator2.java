package step4;

public class TestOperator2 {
	/*
	 	and와 or연산
	 	and: 모든 조건이 참일때 참, 나머지는 거짓 & 또는 &&
	 	or: 모든 조건이 거짓일 때 거짓, 나머지는 참 | 또는 ||
	 	
	 	true && true -> true
	 	true && false -> false
	 	false && true -> false
	 	false && false -> false
	 	
	 	true || true -> true
	 	true || false -> true
	 	false || true -> true
	 	false || false -> false
	 	
	 	& 와 &&, | 와 || 는 어떤 차이가 있을까? 성능향상을 목적으로 &&와 ||를 사용한다.
	 	&&를 사용하면 false가 먼저 도출되면 그 결과는 false이므로 이후 연산은 수행하지 않고 연산을 마친다.
	 	||를 사용하면 true가 먼저 도출되면 그 결과는 당연히 false이므로 바로 연산을 마치고 true를 반환한다.
	 	예제로 테스트 해본다.
	 */
	public static void main(String[] args) {
		OperatorExam exam = new OperatorExam();
		System.out.println(exam.test1() && exam.test2());
		System.out.println("**위, 아래 코드의 실행결과를 비교해본다");
		System.out.println(exam.test1() & exam.test2());
	}
}
