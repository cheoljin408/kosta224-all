package step2;

import java.io.InputStream;
import java.util.Scanner;

public class TestConsoleInput {
	// �ֿܼ��� �Է¹޴� ����
	public static void main(String[] args) {
		// �ֿܼ� ����Ǵ� NodeStream �� �Է� ��Ʈ��
		/*
		 	ģ���̸��� �Է��ϼ���: ������
		 	ģ���̸�: ������
		 	ģ���̸��� �Է��ϼ���: ��ȿ��
		 	ģ���̸�: ��ȿ��
		 	ģ���̸��� �Է��ϼ���: �̻��
		 	ģ���̸�: �̻��
		 	ģ���̸��� �Է��ϼ���: ����
		 	���α׷��� ����Ǿ����ϴ�

		 */
		InputStream is = System.in;
		
		// ProcessingStream ��� ����
		Scanner s = new Scanner(is);
		
		while(true) {
			System.out.print("ģ�� �̸��� �Է��ϼ���:");
			String name = s.nextLine();
			if(name.equals("����")) {
				System.out.println("���α׷��� ����Ǿ����ϴ�");
				break;
			}
			System.out.println("ģ���̸�:" + name);
			
		}
		s.close();
	}
}
