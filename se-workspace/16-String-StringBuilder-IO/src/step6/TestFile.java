package step6;

import java.io.File;
import java.io.IOException;

// java.io.File 을 이용해 실제 파일을 다루는 예제
public class TestFile {
	public static void main(String[] args) {
		String path = "C:" + File.separator + "kosta224";
		File dir = new File(path);
		System.out.println(dir.exists());
		System.out.println(dir.isDirectory());
		System.out.println(dir.isFile());
		System.out.println(dir.getPath());
		
		File dir2 = new File(dir.getPath() + File.separator + "iotest");
		System.out.println(dir2.getPath());
		System.out.println(dir2.exists());
		// directory를 실제로 만들어본다
		System.out.println("mkdir:" + dir2.mkdir());
		// iotest와 같은 위치에 iotest2 디렉토리와 하위 디렉토리 music을 한번 실행해서 함께 생성해본다
		// iotest 즉 dir2의 상위 디렉토리 객체를 반환받는다 getParentFile();
		File pd = dir2.getParentFile();
		System.out.println(pd.getPath());
		File dir3 = new File(pd.getPath() + File.separator + "iotest2" + File.separator + "music");
		System.out.println(dir3.getPath());
		System.out.println(dir3.mkdirs());
		
		// 파일생성
		File file = new File(dir3.getPath() + File.separator + "info3.txt");
		try {
			System.out.println("file 생성:" + file.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
