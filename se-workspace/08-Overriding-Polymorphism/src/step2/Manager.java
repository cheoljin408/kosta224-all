package step2;

// 매니저는 사원이다.
// Manager is a Employee 즉 상속관계
// Employee를 상속받으면 Employee의 멤버(변수, 메소드를)를 물려받아 재사용할 수 있으므로
// 재사용성 증대 -> 생산성 향상
public class Manager extends Employee {
	// Manager의 독자적 인스턴스 변수만 명시하면 된다
	private String department;
	/*
	 	생성자를 명시하지 않았을 경우 아래와 같은 디폴트 생성자가 삽입된다
	 	이 때 부모 클래스에는 디폴트 생성자가 존재하지 않으므로
	 	아래는 컴파일 에러가 남
	 	public Manager() { super(); }
	 	부모 생성자의 매개변수에 알맞는 super()를 정의하면 된다
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
