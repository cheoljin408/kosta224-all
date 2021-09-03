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

	// path ���Ͽ� menu ������ ���
	// Node: FileWriter
	// Process: PrintWriter
	// Exception: throws
	public void writeFile(String menu) throws IOException {
		// PrintWriter pw = new PrintWriter(new FileWriter(path));
		
		FileWriter fw = new FileWriter(path, true); // true �� append �� �߰� ����
		PrintWriter pw = new PrintWriter(fw);
		pw.println(menu);
		pw.close(); // ��Ʈ���� �ݾ��ش�(�̶� �޸�(buffer)�� �ִ� �����͸� ���� ���Ͽ� ����Ѵ� - flush)
	}
}
