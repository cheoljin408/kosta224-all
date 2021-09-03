package step09.ex.test.step4;

import java.io.File;

/*
 	파일을 이동시키는 단위 테스트
 	File class의 renameTo()를 이용하면 된다
 */
public class TestFileMove {
	public static void main(String[] args) {
		String orgPath = "C:\\kosta224\\iotest\\org\\image.PNG";
		String destPath = "C:\\kosta224\\iotest\\dest\\image.PNG";
		
		File orgFile = new File(orgPath);
		File destFile = new File(destPath);
		
		boolean result = orgFile.renameTo(destFile);
		System.out.println("move:" + result);
	}
}
