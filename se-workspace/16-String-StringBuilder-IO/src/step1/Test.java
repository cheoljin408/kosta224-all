package step1;

class Ex {
	String message;
	Ex(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}

class MyEx extends Ex {
	MyEx(String message) {
		super(message);
	}
}

public class Test {
	public static void main(String[] args) {
		MyEx m = new MyEx("a"); // 부모 인스턴스 변수 message에 할당
		System.out.println(m.getMessage()); // 상속받은 메소드를 호출
	}
}
