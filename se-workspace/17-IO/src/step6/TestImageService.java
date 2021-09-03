package step6;

import java.io.IOException;

public class TestImageService {
	public static void main(String[] args) {
		String orgImgPath = "C:\\kosta224\\iotest3\\son.jpg";
		String destImgPath = "C:\\kosta224\\iotest4\\복사본-son.jpg";
		ImageService service = new ImageService(orgImgPath, destImgPath);
		
		try {
			service.copyAndPasteImg();
			System.out.println("이미지 작업 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
