package step7;

public class Engineer extends Employee {
	private String skill;
	
	public Engineer(String empNo, String name, int salary, String skill) {
		super(empNo, name, salary);
		this.skill = skill;
	}

	// �޼ҵ� �������̵�
	@Override // ������̼� -> �ǹ��ִ� �ּ�, �����ϰ� ��Ÿ�ӽ� ������ �ش�
	// @Override ������̼��� �����Ͻÿ� �������̵� ������ üũ���ش�
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " skill:" + skill;
	}
}
