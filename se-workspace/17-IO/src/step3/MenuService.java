package step3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MenuService {
	private String path;

	/*
	 	생성자 매개변수로 전달받는 파일경로에 해당하는 디렉토리가
	 	존재하지 않는다면 디렉토리를 생성한다
	 	java.io.File getParentFile(), isDirectory(), mkdirs()
	 */
	public MenuService(String path) {
		super();
		this.path = path;
		
		// 파일 경로의 상위 디렉토리 정보를 반환받는다
		File dir = new File(path).getParentFile();
		if(dir.isDirectory() == false) {
			dir.mkdirs();
		}
	}

	// throws
	public void order() throws IOException {
		Scanner s = null;
		PrintWriter pw = null;
		
		try {
			// 입력 스트림
			s = new Scanner(System.in);
			pw = new PrintWriter(new FileWriter(path, true));
			
			while(true) {
				System.out.print("점심메뉴를 주문하세요:");
				String order = s.nextLine();
				if(order.equals("주문끝")) {
					System.out.println("주문이 완료되었습니다");
					break;
				}
				pw.println(order);
				System.out.println(order + "주문");
			}
		} finally {
			if(pw != null)
				pw.close(); // close() 시에 flush()로 출력
			if(s != null)
				s.close();
		}
		
		/*
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new FileWriter(path, true));
		String menu;
		
		while(true) {
			System.out.print("점심메뉴를 주문하세요:");
			menu = s.nextLine();
			if(menu.equals("주문끝")) {
				System.out.println("주문이 완료되었습니다");
				break;
			}
			pw.println(menu);
		}
		pw.close();
		*/
	}
	
	
}
