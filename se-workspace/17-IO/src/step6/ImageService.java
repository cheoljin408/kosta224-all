package step6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageService {
	private String orgImgPath;
	private String destImgPath;
	
	public ImageService(String orgImgPath, String destImgPath) {
		super();
		this.orgImgPath = orgImgPath;
		this.destImgPath = destImgPath;
		
		// 디렉토리 만들어주기
		new File(destImgPath).getParentFile().mkdirs();
	}

	/**
	 * 이미지 처리를 위해 1byte 단위의 스트림을 이용한다
	 * 입력 스트림 FileInputStream, BufferedInputStream
	 * 출력 스트힘 FileOutputStream, BufferedOutputStream
	 * @throws IOException 
	 */
	public void copyAndPasteImg() throws IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(orgImgPath));
			bos = new BufferedOutputStream(new FileOutputStream(destImgPath));
			
			int data = bis.read(); // read() 메소드는 더이상 읽을 바이트가 없으면 -1을 반환
			while(data != -1) {
				bos.write(data);
				data = bis.read();
			}
		} finally {
			if(bos != null)
				bos.close();
			if(bis != null)
				bis.close();
		}
	}
	
	
}
