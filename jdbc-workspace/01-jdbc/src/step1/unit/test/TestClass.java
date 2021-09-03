package step1.unit.test;

// Class.forName 메소드의 역할을 확인하는 클래스
public class TestClass {
	public static void main(String[] args) {
		String myDriver = "step1.unit.driver.MyDriver";
		try {
			Class.forName(myDriver); // MyDriver class loading -> static 영역 실행되고 meta space에 저장
			System.out.println("**MyDriver class loading**");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
