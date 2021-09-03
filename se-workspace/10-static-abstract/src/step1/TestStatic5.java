package step1;

public class TestStatic5 {
	public static void main(String[] args) {
		System.out.println("main method 실행");
	}
	
	// static 초기화 영역: static 초기화 블럭은 main method에 우선해서 실행
	static {
		System.out.println("static 초기화 영역");
	}
}
