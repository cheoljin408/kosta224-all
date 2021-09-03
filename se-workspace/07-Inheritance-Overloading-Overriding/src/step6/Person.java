package step6;

public class Person extends Animal {
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public void printDetail() {
		// 아래 age는 상속받았지만 부모 클래스에서
		// private 접근 제어자로 선언되어 있으므로
		// 접근 불가
		// System.out.println(name + " " + age);
		
		// 이 경우 아래와 같이 getter로 접근하면 된다.
		System.out.println(name + " " + getAge());
	}
}
