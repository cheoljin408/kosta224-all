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
			System.out.println("MoveFileWorker Thread가 파일을 이동");
		}
	}
	
	// 이동시킬 디렉토리가 존재하지 않으면 디렉토리를 생성하는 메소드, run()에서 호출해서 사용
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
		// System.out.println("repository에 생성된 파일들을 확장자별로 movie와 music 디렉토리에 이동");
		// MakeFileWorker Thread가 파일을 생성하는 디렉토리
		File repositoryDir = new File(CommonInfo.MAKE_PATH);
		File[] files = repositoryDir.listFiles(); // repository 디렉토리에 있는 파일(or 디렉토리)들을 배열로 반환
		
		for(int i=0; i<files.length; i++) {
			// System.out.println(files[i].getName() + " 이동시켜야 할 파일");
			String destPath = null;
			if(files[i].getName().endsWith(".avi")) {
				destPath = CommonInfo.MOVIE_PATH;
			}
			else if(files[i].getName().endsWith(".mp3")) {
				destPath = CommonInfo.MUSIC_PATH;
			}
			File destFile = new File(destPath + File.separator + files[i].getName());
			
			// 이동대상파일객체.renameTo(이동할파일객체)
			files[i].renameTo(destFile);
		}
	}
	
	// 내 풀이
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
//			System.out.println("MoveFileWorker Thread가 파일을 이동");
//		}
//	}
}
