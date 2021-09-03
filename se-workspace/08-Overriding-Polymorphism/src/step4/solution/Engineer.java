package step4.solution;

public class Engineer extends Employee {
	private String skill;

	public Engineer(String empNo, String name, int salary, String skill) {
		super(empNo, name, salary); // �θ��� ������ ȣ���Ͽ� ��ü ����
		this.skill = skill;
	}
	
	// �޼ҵ� �������̵�
	public String getDetails() {
		// super�� �̿��� �θ��� getDetails()�� �����ϰ� �߰� �����ؾ� �ϴ� �κи� �ۼ�
		return super.getDetails() + " skill: " + skill;
	}
}
