package step7;

public class Manager extends Employee {
	private String department;

	public Manager(String empNo, String name, int salary, String department) {
		super(empNo, name, salary);
		this.department = department;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " department:" + department;
	}
}
