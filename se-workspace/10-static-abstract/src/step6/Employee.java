package step6;

public class Employee {
	private String empNo;
	private String name;
	private int salary;
	
	public Employee(String empNo, String name, int salary) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "empNo:" + empNo + " name:" + name + " salary:" + salary;
	}
	
	public String printDetail() {
		return "empNo:" + empNo + " name:" + name + " salary:" + salary;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	
}
