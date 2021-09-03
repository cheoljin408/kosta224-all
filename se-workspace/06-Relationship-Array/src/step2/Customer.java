package step2;

public class Customer {
	private String name;
	/*
	 	aggregation: has a ���� �� Customer�� SmartPhone�� ������ �ִ� ����
	 */
	private SmartPhone smartPhone;

	public Customer(String name) {
		super();
		this.name = name;
	}
	
	// ���ϰ��� ����Ʈ�� ��ü�� �ּҰ��̹Ƿ� ����Ÿ���� Ŭ�������� SmartPhone�� �ȴ�.
	public SmartPhone getSmartPhone() {
		return smartPhone;
	}
	
	// ȣ���� ������ ������ ���ڰ��� ����Ʈ�� ��ü�� �ּҰ��̰�
	// �̸� ���޹ޱ� ���� �Ű������� Ÿ���� SmartPhone ��ü��
	// Ŭ�������� SmartPhone�� �ȴ�.
	public void setSmartPhone(SmartPhone smartPhone) {
		this.smartPhone = smartPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
