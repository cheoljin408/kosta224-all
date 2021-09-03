package step5;

import java.io.IOException;
import java.util.ArrayList;

public class TestObjectSerialization3 {
	public static void main(String[] args) {
		// 다수의 객체를 ArrayList에 저장하여 객체 직렬화하는 예제
		String path = "C:\\kosta224\\iotest\\carlist.obj";
		CarService service = new CarService(path);
		
		ArrayList<Car> list = new ArrayList<Car>();
		list.add(new Car("K5", 2000));
		list.add(new Car("QM6", 2500));
		
		try {
			service.saveList(list);
			System.out.println("car list를 직렬화하여 저장");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
