package step1;

public class Service {

	public void test(int age) throws AgeException {
		try {
			if(age < 1) {
				throw new AgeException("a");
			}
			System.out.println("b");
		} finally {
			System.out.println("c");
		}
	}

}
