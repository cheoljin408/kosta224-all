package step7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestOutput1 {
	public static void main(String[] args) {
		// ��ġ�� ����Ǵ� Node Stream �迭�� ����
		try {
			FileWriter fw = new FileWriter("C:\\kosta224\\iotest\\memo.txt", true); // true �� append �� �߰� ����
			// ����� �����ϴ� Processing Stream �迭�� ����
			PrintWriter pw = new PrintWriter(fw);
			pw.println("���½ð��Դϴ�");
			System.out.println("���ϻ��� �� ���");
			pw.close(); // ��Ʈ���� �ݾ��ش�(�̶� �޸�(buffer)�� �ִ� �����͸� ���� ���Ͽ� ����Ѵ� - flush)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
