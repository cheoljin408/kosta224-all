package step6;

/*
 	상속받았다고 하더라도 부모의 private 접근 제어자가 
 	명시된 멤버에는 클래스가 다르므로 접근 불가하다.
 	이 경우 접근하기 위해서는 getter, setter를 이용해 간접 접근하면 된다.
 */

public class TestInheritance2 {
	public static void main(String[] args) {
		Person p = new Person("아이유");
		// p.name = "아이유";
		p.printDetail();
	}
}
