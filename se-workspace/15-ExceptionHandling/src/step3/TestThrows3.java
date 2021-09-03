package step3;

/*
 	Exception Handling 예외 처리에 대한 실행 결과를 예상해보는 에제
 	try, catch, finally, throws, throw 이해를 확인
 */
class TestException extends Exception {
	/**
	 * 이후 공부 예정
	 */
	private static final long serialVersionUID = 6053676066141987488L;

	TestException(String message) {
		super(message);
	}
}

class Service {
	public void test(String name) throws TestException {
		try {
			if(name == null) {
				throw new TestException("a");
			}
			System.out.println("b");
		} finally {
			System.out.println("c");
		}
		System.out.println("d");
	}
}

public class TestThrows3 {
	public static void main(String[] args) {
		Service s = new Service();
		try {
			// 예외발생 case
			// s.test(null);
			
			// 정상수행 case
			s.test("신난다");
		} catch(TestException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("f");
	}
}
