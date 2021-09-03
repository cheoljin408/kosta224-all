package step1;

import java.util.Scanner;

/*
 	java.util.Scanner를 이용해 콘솔상에서 데이터를 입력받아보는 예제
 */
public class TestScanner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("아래 라인에 정보를 입력하세요");
		String info = s.nextLine(); // 정보 입력 후 엔터키를 누르면 실행된다
		System.out.println("입력받은 정보: " + info);
		
		s.close();
	}
}
