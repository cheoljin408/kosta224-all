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
		// filePath�� �ش��ϴ� ���Ͽ� data�� ����Ѵ�
		// ���Ͽ� ����Ǵ� NodeStream ����
		//FileWriter fw = new FileWriter(filePath, true); // true: append �߰�
		
		// NodeStream�� ����Ǿ� ����� �����ϴ� ProcessingStream ����
		//PrintWriter pw = new PrintWriter(fw);
		
		// �� �� ������ �ٷ��� ����
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(filePath, true));
			pw.println(data);
		} finally {
			// ��Ʈ���� �ݾ��ش�(����� �ڿ��� ������� �����ش�),
			// ���������� flush()�� ȣ���ؼ� buffer(�޸�)�� �ִ� ������ ���� ���Ͽ� ���
			if(pw != null) {
				pw.close();
			}
		}
	}
}
