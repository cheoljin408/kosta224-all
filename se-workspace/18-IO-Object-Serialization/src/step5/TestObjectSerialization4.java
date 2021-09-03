package step5;

import java.io.IOException;
import java.util.ArrayList;

public class TestObjectSerialization4 {
	public static void main(String[] args) {
		// 다수의 객체를 ArrayList에 저장하여 객체 직렬화하는 예제
		String path = "C:\\kosta224\\iotest\\carlist.obj";
		CarService service = new CarService(path);
		
		try {
			ArrayList<Car> list = service.loadList();
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getModel());
			}
			System.out.println("car list를 역직렬화하여 확인");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
