package step7;

public class Engineer extends Employee {
	private String skill;
	
	public Engineer(String empNo, String name, int salary, String skill) {
		super(empNo, name, salary);
		this.skill = skill;
	}

	// 메소드 오버라이딩
	@Override // 어노테이션 -> 의미있는 주석, 컴파일과 런타임시 영향을 준다
	// @Override 어노테이션은 컴파일시에 오버라이드 문법을 체크해준다
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " skill:" + skill;
	}
}
