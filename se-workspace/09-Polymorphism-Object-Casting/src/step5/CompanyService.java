package step5;

public class CompanyService {
	public void printDetailInfo(Employee e) {
		System.out.println(e.printDetail());
		
		// toString �޼ҵ带 �������̵� �����Ƿ� �Ʒ��� ���� ����ϸ� �ȴ�.
		System.out.println(e);
	}
}
