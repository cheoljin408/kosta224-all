package step5;

public class TestsArray1 {
	public static void main(String[] args) {
		// 배열 선언
		int age[];
		// 배열 생성
		age = new int[3];
		// 배열 요소에 값을 할당
		age[0] = 22;
		age[1] = 18;
		age[2] = 26;
		// 배열 요소를 출력
		System.out.println(age[2]);
		// 베열 길이
		System.out.println(age.length);
		
		System.out.println("*****for loop을 이용해 age 배열 모든 요소를 출력*****");
		for(int i=0; i<age.length; i++) {
			System.out.println(age[i]);
		}
	}
}
