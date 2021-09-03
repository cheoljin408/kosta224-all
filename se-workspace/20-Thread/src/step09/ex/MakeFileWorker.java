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

	// ����� Ǯ��

	// ���丮 ����� �޼ҵ�
	public void makeDir() {
		File dir = new File(CommonInfo.MAKE_PATH);
		if (dir.isDirectory() == false) {
			dir.mkdirs();
		}
	}

	// ���� ����� �޼ҵ�
	public void makeFile() throws InterruptedException, IOException {
		for (int i = 0; i < makeCount; i++) {
			String fileName = createFileName(i);
			File file = new File(CommonInfo.MAKE_PATH + File.separator + fileName);
			file.createNewFile();
			System.out.println(fileName + "���� - MakeFileWorker Thread");
			Thread.sleep(makePeriod);
		}
	}

	// ���ϸ��� �����ϴ� �޼ҵ�, makeFile �޼ҵ忡�� ȣ���ؼ� ���
	// �Ű������� ���ڰ����� ������ ������ �̿��ϰ� �ð������� Ȯ���ڸ� �߰��ؼ� ���ϸ��� ���� ��
	// �����ϴ� �޼ҵ�
	public String createFileName(int i) {
		String fileName = i + "_" + System.currentTimeMillis();
		Random r = new Random();
		if (r.nextBoolean())
			fileName += ".avi";
		else
			fileName += ".mp3";
		return fileName;
	}

	// �� Ǯ��
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
//			 String fileName = i + "_" + time + ext; System.out.println(fileName + " ���� - MakeFileWorker Thread");
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
