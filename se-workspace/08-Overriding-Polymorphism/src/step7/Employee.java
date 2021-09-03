package step7;

public class Employee { // extends Object
	private String empNo;
	private String name;
	private int salary;
	
	public Employee(String empNo, String name, int salary) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
	}
	
	// Object 부모 클래스의 toString() 메소드를 오버라이딩해서 주소값 대신 실제 내용값을 반환하게 한다.
	public String toString() {
		return "empNo:" + empNo + " name:" + name + " salary:" + salary;
	}
}
