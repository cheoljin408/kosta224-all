package step7;
/*
 	�ڵ� ���� ����� �����غ���
 */
public class TestObjectInit2 {
	public static void main(String[] args) {
		Food f = new Food("Į����", 7000);
		ObjectInitExam exam = new ObjectInitExam();
		// Į���� 7000 ������ ���� ��ü�� �ּҰ��� 
		// pass1 �޼ҵ��� ���ڰ����� �����Ѵ�.
		exam.pass1(f);
		System.out.println(f.getName() + " " + f.getPrice());
		exam.pass2(f);
		System.out.println(f.getName() + " " + f.getPrice());
	}
}
