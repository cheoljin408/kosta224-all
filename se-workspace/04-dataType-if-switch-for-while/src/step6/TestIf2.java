package step6;

public class TestIf2 {
	public static void main(String[] args) {
		MyDate d = new MyDate();
		d.setMonth(8);
		System.out.println(d.getMonth());
		System.out.println("*****");
		
		// month�� 1~12 ������ ���̾�� �Ѵ�.
		MyDate d2 = new MyDate();
		d2.setMonth(13);// 13���� �߸��� �Է°��Դϴ�.
		System.out.println(d2.getMonth());// 1
	}
}
