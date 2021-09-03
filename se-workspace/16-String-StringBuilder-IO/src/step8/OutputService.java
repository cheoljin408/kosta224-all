package step8;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputService {
	private String path;

	public OutputService(String path) {
		super();
		this.path = path;
	}

	// path 파일에 menu 정보를 출력
	// Node: FileWriter
	// Process: PrintWriter
	// Exception: throws
	public void writeFile(String menu) throws IOException {
		// PrintWriter pw = new PrintWriter(new FileWriter(path));
		
		FileWriter fw = new FileWriter(path, true); // true 는 append 즉 추가 가능
		PrintWriter pw = new PrintWriter(fw);
		pw.println(menu);
		pw.close(); // 스트림을 닫아준다(이때 메모리(buffer)에 있는 데이터를 실제 파일에 출력한다 - flush)
	}
}
