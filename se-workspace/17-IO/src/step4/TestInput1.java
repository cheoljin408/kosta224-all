package step4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 	�Է� ��Ʈ���� �̿��� ���Ͽ��� �����͸� �Է¹޴� ����
 */
public class TestInput1 {
	public static void main(String[] args) {
		try {
			// ���Ͽ� �Է¹ޱ� ���� NodeStream�� ����
			FileReader rf = new FileReader("C:\\kosta224\\iotest2\\lunch\\menu.txt");
			
			// �� ���ξ� �Է¹޴� ����� �����ϴ� ProcessingStream�� ����
			BufferedReader br = new BufferedReader(rf);
			System.out.println(br.readLine()); // �� ���ξ� �Է¹޴´�
			System.out.println(br.readLine()); // �� ���� ������ �Է¹޴´�
			System.out.println(br.readLine()); // �� �̻� ���� ������ �����Ƿ� null�� ��ȯ�Ѵ�
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
