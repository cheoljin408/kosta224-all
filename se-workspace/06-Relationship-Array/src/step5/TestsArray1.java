package step5;

public class TestsArray1 {
	public static void main(String[] args) {
		// �迭 ����
		int age[];
		// �迭 ����
		age = new int[3];
		// �迭 ��ҿ� ���� �Ҵ�
		age[0] = 22;
		age[1] = 18;
		age[2] = 26;
		// �迭 ��Ҹ� ���
		System.out.println(age[2]);
		// ���� ����
		System.out.println(age.length);
		
		System.out.println("*****for loop�� �̿��� age �迭 ��� ��Ҹ� ���*****");
		for(int i=0; i<age.length; i++) {
			System.out.println(age[i]);
		}
	}
}
