package step5;

public class TestArray3 {
	public static void main(String[] args) {
		// �迭 ����, ����, �Ҵ�, ���ÿ�
		int price[] = {200, 300, 100, 2000, 1200}; // �迭 length 5�� ��ü�� �����ϰ� ��ҿ� ���� �Ҵ�
		int money = 500;
		// price �迭 ����� money�� �ʰ��ϴ� �迭 ����� price�� ��� ����Ѵ�.
		// for loop �ȿ��� if���� �̿��ϸ� �ȴ�.
		for(int i=0; i<price.length; i++) {
			if(money < price[i]) {
				System.out.println(price[i]);
			}
		}
	}
}
