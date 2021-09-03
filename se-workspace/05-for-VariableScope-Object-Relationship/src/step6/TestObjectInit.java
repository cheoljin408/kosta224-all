package step6;

public class TestObjectInit {
	public static void main(String[] args) {
		int year = 2021;
		MyDate d = new MyDate(year);
		System.out.println(d.getYear() + " " + d.getMonth() + " " + d.getDay());
	}
}
