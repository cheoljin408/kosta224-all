package step4;

public class TestSetterGetter {
	public static void main(String[] args) {
		KostaMember m=new KostaMember();
		//private 이므로 접근 불가 compile error 
		//m.id="javaking";
		m.setId("javaking");
		System.out.println(m.getId());
		m.setPassword("abcd");
		System.out.println(m.getPassword());
	}
}
