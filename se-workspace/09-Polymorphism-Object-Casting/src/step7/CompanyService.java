package step7;

import step4.Animal;
import step4.Person;

public class CompanyService {
	public void playAll(Animal[] a) {
		for(int i=0; i<a.length; i++) {
			// �迭 ��Ұ� Person ��ü���� Ȯ��
			if(a[i] instanceof Person) {
				// Person�� ������ ���(�޼ҵ�)�� �����ϱ� ���� Object down casting�� �Ѵ�
				((Person) a[i]).ticketing();
			}
			a[i].play();
		}
	}
}
