package step3;

public class TestForLoop3 {
	public static void main(String[] args) {
		/*
		 	������ 2�ܺ��� 9�ܱ��� ���
		 	��ø for(Nested Loop)�� �̿��Ѵ�.
		 */
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.print(i+"*"+j+"="+i*j+" \t");
			}
			System.out.println();
		}
	}
}
