package step5.access;
// 접근 제어자 테스트를 위한 클래스, protected 접근 제어자를 확인해본다.
public class Bank {
	public void publicTest() {
		System.out.println("public method");
	}
	
	protected void protectedTest() {
		System.out.println("protected method");
	}
	
	void defaultTest() {
		System.out.println("default method");
	}
	
	/*
	 * private void privateTest() { System.out.println("private method"); }
	 */
}
