package step1;

import java.util.Scanner;

/*
 	java.util.Scanner�� �̿��� �ֻܼ󿡼� �����͸� �Է¹޾ƺ��� ����
 */
public class TestScanner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("�Ʒ� ���ο� ������ �Է��ϼ���");
		String info = s.nextLine(); // ���� �Է� �� ����Ű�� ������ ����ȴ�
		System.out.println("�Է¹��� ����: " + info);
		
		s.close();
	}
}
