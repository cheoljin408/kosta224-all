package step1;

public class Engineer extends Employee {
	private String skill;

	public Engineer(String empNo, String name, int salary, String skill) {
		super(empNo, name, salary);
		this.skill = skill;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " skill:" + skill;
	}
	
	@Override
	public String printDetail() {
		// TODO Auto-generated method stub
		return super.printDetail() + " skill:" + skill;
	}
}
