package step8;

import java.io.IOException;

public class TestOutput2 {
	public static void main(String[] args) {
		String path = "C:\\kosta224\\iotest\\dinner.txt";
		OutputService service = new OutputService(path);
		
		try {
			service.writeFile("����");
			System.out.println("������ ��� �Ϸ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
