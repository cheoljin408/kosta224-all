package step6;

import java.io.IOException;

public class TestImageService {
	public static void main(String[] args) {
		String orgImgPath = "C:\\kosta224\\iotest3\\son.jpg";
		String destImgPath = "C:\\kosta224\\iotest4\\���纻-son.jpg";
		ImageService service = new ImageService(orgImgPath, destImgPath);
		
		try {
			service.copyAndPasteImg();
			System.out.println("�̹��� �۾� �Ϸ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
