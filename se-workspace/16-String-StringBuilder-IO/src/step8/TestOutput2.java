package step8;

import java.io.IOException;

public class TestOutput2 {
	public static void main(String[] args) {
		String path = "C:\\kosta224\\iotest\\dinner.txt";
		OutputService service = new OutputService(path);
		
		try {
			service.writeFile("피자");
			System.out.println("데이터 출력 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
