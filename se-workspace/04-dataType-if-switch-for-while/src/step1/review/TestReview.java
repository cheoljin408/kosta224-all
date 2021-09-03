package step1.review;

public class TestReview {
	public static void main(String[] args) {
		Person p = new Person("아이유");
		System.out.println(p.getName());
		p.setName("이강인");
		System.out.println(p.getName());
	}
}
