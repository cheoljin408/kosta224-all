package step2;

// �Ŵ����� ����̴�.
// Manager is a Employee �� ��Ӱ���
// Employee�� ��ӹ����� Employee�� ���(����, �޼ҵ带)�� �����޾� ������ �� �����Ƿ�
// ���뼺 ���� -> ���꼺 ���
public class Manager extends Employee {
	// Manager�� ������ �ν��Ͻ� ������ ����ϸ� �ȴ�
	private String department;
	/*
	 	�����ڸ� ������� �ʾ��� ��� �Ʒ��� ���� ����Ʈ �����ڰ� ���Եȴ�
	 	�� �� �θ� Ŭ�������� ����Ʈ �����ڰ� �������� �����Ƿ�
	 	�Ʒ��� ������ ������ ��
	 	public Manager() { super(); }
	 	�θ� �������� �Ű������� �˸´� super()�� �����ϸ� �ȴ�
	 */

	public Manager(String empNo, String name, int salary, String department) {
		super(empNo, name, salary);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
