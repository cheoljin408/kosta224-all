package step2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import step1.Person;

// 객체 역직렬화를 통해 파일에 저장된 객체의 정보를 입력받아 메모리로 복원하는 예제
public class TestObjectInput {
	public static void main(String[] args) {
		// 파일에 연결되는 NodeStream
		try {
			FileInputStream fis = new FileInputStream("C:\\kosta224\\iotest\\person.obj");
			
			//객체 역직렬화를 위한 ProcessingStream
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Person 객체의 name을 반환받아 출력하려고 한다면 Object down casting이 필요
			Person p = (Person)ois.readObject();
			System.out.println(p.getName());
			System.out.println(p);
			ois.close();
			
			System.out.println("입력완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
