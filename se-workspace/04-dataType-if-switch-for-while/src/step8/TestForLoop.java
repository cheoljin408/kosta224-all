package step8;

public class TestForLoop {
	public static void main(String[] args) {
		// for loop: �ݺ��� ����
		System.out.println("**for loop**");
		for(int i=0; i<3; i++) {
			System.out.println("for loop: i->" + i);
		}// for loop
		System.out.println("**while loop**");
		int j = 0;
		while(j<3) {
			System.out.println("while loop: j->" + j++);
		}// while loop
		System.out.println("**do while**");
		// do while loop�� ���������� �� ���� �˻縦 �ϰ� �ݺ��Ѵ�.
		int k = 1;
		do {
			System.out.println("do while: k->" + k++);
		}while(k<0);
	}
}
