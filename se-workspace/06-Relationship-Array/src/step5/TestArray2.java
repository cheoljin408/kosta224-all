package step5;

public class TestArray2 {
	public static void main(String[] args) {
		// �迭 ����, ���� ���ÿ�
		int salary[] = new int[4];
		salary[0] = 400;
		salary[1] = 500;
		salary[2] = 700;
		salary[3] = 600;
		
		// for loop�� �̿��� ������ ���Ѵ�.
		int totalSalary = 0;
		for(int i=0; i<salary.length; i++) {
			totalSalary += salary[i];
		}
		System.out.println("totalSalary: " + totalSalary);
	}
}
