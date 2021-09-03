package step7;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestOutput1 {
	public static void main(String[] args) {
		// 장치에 연결되는 Node Stream 계열을 생성
		try {
			FileWriter fw = new FileWriter("C:\\kosta224\\iotest\\memo.txt", true); // true 는 append 즉 추가 가능
			// 기능을 지원하는 Processing Stream 계열을 생성
			PrintWriter pw = new PrintWriter(fw);
			pw.println("쉬는시간입니다");
			System.out.println("파일생성 및 출력");
			pw.close(); // 스트림을 닫아준다(이때 메모리(buffer)에 있는 데이터를 실제 파일에 출력한다 - flush)
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
