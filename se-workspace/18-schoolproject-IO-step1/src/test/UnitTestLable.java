package test;

import java.util.Scanner;

public class UnitTestLable {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		exit: // label -> break 레이블명 아래 제어문을 벗어난다
		while(true) {
			System.out.print("1, 2 중 입력해봄니다");
			String info = s.nextLine();
			switch(info) {
			case "1":
				System.out.println(info + "등록");
				break;
			case "2":
				System.out.println(info + "종료");
				break exit; // 이 경우 지정된 제어문 while문을 벗어난다
			}
		}
		
		s.close();
	}
}
