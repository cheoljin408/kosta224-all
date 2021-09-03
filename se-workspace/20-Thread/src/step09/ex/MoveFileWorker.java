package step09.ex;

import java.io.File;

public class MoveFileWorker implements Runnable {
	private int moveCount;
	private int movePeriod;
	
	public MoveFileWorker(int moveCount, int movePeriod) {
		super();
		this.moveCount = moveCount;
		this.movePeriod = movePeriod;
	}

	@Override
	public void run() {
		makeDirs();
		for(int i=0; i<moveCount; i++) {
			try {
				Thread.sleep(movePeriod);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moveFiles();
			System.out.println("MoveFileWorker Thread�� ������ �̵�");
		}
	}
	
	// �̵���ų ���丮�� �������� ������ ���丮�� �����ϴ� �޼ҵ�, run()���� ȣ���ؼ� ���
	public void makeDirs() {
		File movieDir =  new File(CommonInfo.MOVIE_PATH);
		File musicDir =  new File(CommonInfo.MUSIC_PATH);
		
		if(movieDir.isDirectory() == false) {
			movieDir.mkdirs();
		}
		if(musicDir.isDirectory() == false) {
			musicDir.mkdirs();
		}
	}
	
	// java.io.File listFiles(): File[]
	// renameTo()
	public void moveFiles() {
		// System.out.println("repository�� ������ ���ϵ��� Ȯ���ں��� movie�� music ���丮�� �̵�");
		// MakeFileWorker Thread�� ������ �����ϴ� ���丮
		File repositoryDir = new File(CommonInfo.MAKE_PATH);
		File[] files = repositoryDir.listFiles(); // repository ���丮�� �ִ� ����(or ���丮)���� �迭�� ��ȯ
		
		for(int i=0; i<files.length; i++) {
			// System.out.println(files[i].getName() + " �̵����Ѿ� �� ����");
			String destPath = null;
			if(files[i].getName().endsWith(".avi")) {
				destPath = CommonInfo.MOVIE_PATH;
			}
			else if(files[i].getName().endsWith(".mp3")) {
				destPath = CommonInfo.MUSIC_PATH;
			}
			File destFile = new File(destPath + File.separator + files[i].getName());
			
			// �̵�������ϰ�ü.renameTo(�̵������ϰ�ü)
			files[i].renameTo(destFile);
		}
	}
	
	// �� Ǯ��
//	public void moveFile() throws InterruptedException {
//		String path = MUSIC_PATH;
//		
//		File dir = new File(path);
//		if(dir.isDirectory() == false) {
//			dir.mkdirs();
//		}
//		path = MOVIE_PATH;
//		
//		dir = new File(path);
//		if(dir.isDirectory() == false) {
//			dir.mkdirs();
//		}
//		
//		for(int i=0; i<moveCount; i++) {
//			Thread.sleep(movePeriod);
//			
//			String orgPath = MAKE_PATH;
//			String destPathMusic = MUSIC_PATH;
//			String destPathMovie = MOVIE_PATH;
//			
//			File orgFile = new File(orgPath);
//			File fileList[] = orgFile.listFiles();
//			
//			for(int j=0; j<fileList.length; j++) {
//				String filename = fileList[j].toString();
//				int nameLen = filename.length();
//				String f = filename.substring(30);
//				
//				
//				if(filename.substring(nameLen-3).equals("avi")) {
//					File dest = new File(destPathMovie + "\\" + f);
//					fileList[j].renameTo(dest);
//				}
//				else if(filename.substring(nameLen-3).equals("mp3")) {
//					File dest = new File(destPathMusic + "\\" + f);
//					fileList[j].renameTo(dest);
//				}
//				
//			}
//			
//			System.out.println("MoveFileWorker Thread�� ������ �̵�");
//		}
//	}
}
