package step5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileService {
	private String copyFilePath;
	private String pasteFilePath;
	/*
	 	pasteFilePath 파일의 디렉토리가 존재하지 않는다면
	 	디렉토리를 생성해준다
	 */
	public FileService(String copyFilePath, String pasteFilePath) {
		super();
		this.copyFilePath = copyFilePath;
		this.pasteFilePath = pasteFilePath;
		
		File dir = new File(pasteFilePath).getParentFile();
		if(dir.isDirectory() == false) {
			dir.mkdirs();
		}
	}
	
	// throws
	/*
	 	copyFilePath의 파일을 입력받아 pasteFilePath에 출력하는 메소드
	 	입력 스트림(BufferedReader)
	 	출력 스트림(PrintWriter)
	 	try, finally -> close
	 	try 구문에서 스트림을 생성
	 	입력받을 데이터가 있을 동안
	 	입력받아 출력을 반복한다
	 */
	public void copyAndPaste() throws IOException {
		// 강사님 풀이
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			br = new BufferedReader(new FileReader(copyFilePath));
			pw = new PrintWriter(new FileWriter(pasteFilePath));
			
			String data = br.readLine(); // 첫 라인을 읽는다
			while(data != null) { // data가 null이 아닐 동안 반복
				pw.println(data); // 파일에 출력
				data = br.readLine(); // 다음 라인을 읽는다
			}
		} finally {
			if(pw != null)
				pw.close();
			if(br != null)
				br.close();
		}
		
		// 내 풀이
		/*
		PrintWriter pw = null;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(copyFilePath));
			pw = new PrintWriter(new FileWriter(pasteFilePath, true));
			
			while(br.ready()) {
				pw.println(br.readLine());
			}
		} finally {
			if(pw != null)
				pw.close();
			if(br != null)
				br.close();
		}
		*/
	}
}
