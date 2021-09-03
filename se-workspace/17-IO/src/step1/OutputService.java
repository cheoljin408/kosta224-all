package step1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputService {
	private String filePath;

	public OutputService(String filePath) {
		super();
		this.filePath = filePath;
	}
	
	public void outputData(String data) throws IOException {
		// filePath에 해당하는 파일에 data를 출력한다
		// 파일에 연결되는 NodeStream 생성
		//FileWriter fw = new FileWriter(filePath, true); // true: append 추가
		
		// NodeStream에 연결되어 기능을 지원하는 ProcessingStream 생성
		//PrintWriter pw = new PrintWriter(fw);
		
		// 위 두 라인을 줄려서 쓰면
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(filePath, true));
			pw.println(data);
		} finally {
			// 스트림을 닫아준다(연결된 자원의 제어권을 놓아준다),
			// 내부적으로 flush()를 호출해서 buffer(메모리)에 있는 정보를 실제 파일에 출력
			if(pw != null) {
				pw.close();
			}
		}
	}
}
