package step5;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("��̸� �Է��ϼ���:");
		String hobby = s.nextLine();
		System.out.print("���̸� �Է��ϼ���:");
		String age = s.nextLine();
		System.out.println("��̴� " + hobby + "���̴� " + age);
		
		s.close();
	}
}
