package step2;

public class Test2DArray {
	public static void main(String[] args) {
		// ������ �迭
		// 3�Ⱓ �ſ� ���췮 ���� -> 2���� �迭
		int rain[][] = new int[3][12];
		// ù�� ù���� ���췮 ����
		rain[0][0] = 100;
		// ù�� 2��
		rain[0][1] = 120;
		// �������� 12��
		rain[2][11] = 200;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<12; j++) {
				System.out.print(rain[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("*************************");
		
		// �������б� 1�г� 3���� 2�г� 5���� 3�г� 6����
		int school[][] = new int[3][];
		school[0] = new int[3];
		school[1] = new int[5];
		school[2] = new int[6];
		
		// �������б� ������ �г��� ������ �ݿ� 20�� �Ҵ� �� ���
		int i = school.length - 1; // �г��� ������ �ε��� 2
		int j = school[i].length - 1; // �г⿡ ������ ���� ������ �ε��� 5
		school[i][j] = 20;
		System.out.println(school[i][j]);
	}
}
