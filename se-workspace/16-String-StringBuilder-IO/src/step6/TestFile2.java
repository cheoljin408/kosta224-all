package step6;

import java.io.File;

public class TestFile2 {
	public static void main(String[] args) {
		File dir = new File("C:\\kosta224\\iotest2\\music");
		// dir 즉 music 디렉토리 안에 있는 파일들만 (폴더는 제외) 모두 파일명을 출력
		File fa[] = dir.listFiles();
		// for loop
		// isFile(), getName() 를 이용
		for(int i=0; i<fa.length; i++) {
			if(fa[i].isFile()) {
				System.out.println(fa[i].getName());
			}
		}
	}
}
