package step5;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("취미를 입력하세요:");
		String hobby = s.nextLine();
		System.out.print("나이를 입력하세요:");
		String age = s.nextLine();
		System.out.println("취미는 " + hobby + "나이는 " + age);
		
		s.close();
	}
}
