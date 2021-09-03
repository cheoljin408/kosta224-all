package step1;

public class TestExceptionReview {
	public static void main(String[] args) {
		Service s = new Service();
		int age = -1;
		//age = 7;
		try {
			s.test(age);
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}
	}
}
