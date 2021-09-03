package step4.solution;

public class Engineer extends Employee {
	private String skill;

	public Engineer(String empNo, String name, int salary, String skill) {
		super(empNo, name, salary); // 부모의 생성자 호출하여 객체 생성
		this.skill = skill;
	}
	
	// 메소드 오버라이딩
	public String getDetails() {
		// super를 이용해 부모의 getDetails()를 재사용하고 추가 구현해야 하는 부분만 작성
		return super.getDetails() + " skill: " + skill;
	}
}
