package step09.ex;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MakeFileWorker implements Runnable {
	private int makeCount;
	private int makePeriod;

	public MakeFileWorker(int makeCount, int makePeriod) {
		super();
		this.makeCount = makeCount;
		this.makePeriod = makePeriod;
	}

	@Override
	public void run() {
		makeDir();
		try {
			makeFile();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	// 강사님 풀이

	// 디렉토리 만드는 메소드
	public void makeDir() {
		File dir = new File(CommonInfo.MAKE_PATH);
		if (dir.isDirectory() == false) {
			dir.mkdirs();
		}
	}

	// 파일 만드는 메소드
	public void makeFile() throws InterruptedException, IOException {
		for (int i = 0; i < makeCount; i++) {
			String fileName = createFileName(i);
			File file = new File(CommonInfo.MAKE_PATH + File.separator + fileName);
			file.createNewFile();
			System.out.println(fileName + "생성 - MakeFileWorker Thread");
			Thread.sleep(makePeriod);
		}
	}

	// 파일명을 생성하는 메소드, makeFile 메소드에서 호출해서 사용
	// 매개변수의 인자값으로 전달한 정보를 이용하고 시간정보와 확장자를 추가해서 파일명을 만든 후
	// 리턴하는 메소드
	public String createFileName(int i) {
		String fileName = i + "_" + System.currentTimeMillis();
		Random r = new Random();
		if (r.nextBoolean())
			fileName += ".avi";
		else
			fileName += ".mp3";
		return fileName;
	}

	// 내 풀이
//	 public void makeFile() throws InterruptedException {
//		 String path = MAKE_PATH;
//	 
//		 File dir = new File(path);
//		 if(dir.isDirectory() == false) {
//			 dir.mkdirs();
//		 }
//	 
//		 for(int i=0; i<makeCount; i++) {
//			 long time = System.currentTimeMillis();
//			 Random r = new Random(); String ext = null;
//	 
//			 if(r.nextBoolean()) 
//				 ext = ".avi"; 
//			 else 
//				 ext = ".mp3"; 
//			 String fileName = i + "_" + time + ext; System.out.println(fileName + " 생성 - MakeFileWorker Thread");
//	 
//			 String filePath = path + "\\" + fileName;
//	 
//			 File file = new File(filePath);
//			 try {
//				 file.createNewFile();
//			 } catch (IOException e) {
//				 e.printStackTrace();
//			 }
//	 
//			 Thread.sleep(makePeriod);
//		 }
//	 }
}
