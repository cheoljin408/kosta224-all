package step4.solution;

public class Manager extends Employee {
	private String department;

	public Manager(String empNo, String name, int salary, String department) {
		super(empNo, name, salary);
		this.department = department;
	}
	
	// 메소드 오버라이딩
	public String getDetails() {
		return super.getDetails() + " department: " + department;
	}
}
