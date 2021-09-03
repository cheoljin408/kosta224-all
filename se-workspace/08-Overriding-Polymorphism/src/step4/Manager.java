package step4;

public class Manager extends Employee {
	private String department;

	public Manager(String empNo, String name, int salary, String department) {
		super(empNo, name, salary);
		this.department = department;
	}
	
	public String getDetails() {
		return super.getDetails() + " department: " + department;
	}
}
