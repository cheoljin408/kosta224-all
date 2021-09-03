package step1;

import java.io.IOException;

public class TestOutputReview {
	public static void main(String[] args) {
		String filePath = "C:\\kosta224\\iotest\\friend.txt";
		OutputService service = new OutputService(filePath);
		
		try {
			service.outputData("적재");
			System.out.println("출력완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("프로그램 정상수행");
	}
}
