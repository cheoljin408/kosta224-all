package step3;

class Human {
	private String name;
	private int salary;
	
	Human() {}
	
	// 생성자 오버로딩: 동일한 이름으로 다양한 매개변수를 정의
	Human(String name) {
		this.name = name;
	}
	
	// 생성자 오버로딩
	Human(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}

public class TestOverloading2 {
	public static void main(String[] args) {
		Human h1 = new Human();
		System.out.println(h1.getName() + " " + h1.getSalary()); // null 0
		Human h2 = new Human("김연경"); // 다양한 인자값으로 객체를 생성
		System.out.println(h2.getName() + " " + h2.getSalary()); // 김연경 0
		Human h3 = new Human("강백호", 300); // 생성자와 오버로딩이 되어 있으므로 다양한 인자값으로 객체를 생성할 수 있다.
		System.out.println(h3.getName() + " " + h3.getSalary());
	}
}
