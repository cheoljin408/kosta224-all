package step2;

import java.io.InputStream;
import java.util.Scanner;

public class TestConsoleInput {
	// 콘솔에서 입력받는 예제
	public static void main(String[] args) {
		// 콘솔에 연결되는 NodeStream 중 입력 스트림
		/*
		 	친구이름을 입력하세요: 아이유
		 	친구이름: 아이유
		 	친구이름을 입력하세요: 이효리
		 	친구이름: 이효리
		 	친구이름을 입력하세요: 이상순
		 	친구이름: 이상순
		 	친구이름을 입력하세요: 종료
		 	프로그램이 종료되었습니다

		 */
		InputStream is = System.in;
		
		// ProcessingStream 기능 지원
		Scanner s = new Scanner(is);
		
		while(true) {
			System.out.print("친구 이름을 입력하세요:");
			String name = s.nextLine();
			if(name.equals("종료")) {
				System.out.println("프로그램이 종료되었습니다");
				break;
			}
			System.out.println("친구이름:" + name);
			
		}
		s.close();
	}
}
