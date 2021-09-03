package step1;

public class TestStatic2 {
	// instance variable
	String name="아이유";
	
	// static variable: static member 사용은 신중하게 해야 한다. -> class loading 시점에 한 번 메모리에 적재, 계속 유지가 되므로
	static String name2 = "박보검";
	
	// object member method
	public void test1() {
		System.out.println("object member method test1" + name);
	}
	
	// static member method
	public static void test2() {
		// test1(); // compile error: static -> non-static으로 바로 접근 불가
		// 아래와 같이 객체를 생성해야 한다
		new TestStatic2().test1();
	}
	
	public void test3() {
		test2(); // object의 member method test3()은 실행을 위해서는 객체 생성을 전제로 하므로 static member에 바로 접근 가능
		// test3()이 실행된다는 것은 class loading -> 객체 생성을 전제로 하니까 static은 미리 class loading 시점에 적재되므로
		// non-static 에서 static 으로 바로 접근 가능
	}
	
	public static void main(String[] args) {
		// compile error: name은 instance variable이므로 객체 생성시에만 메모리에 적재
		// static에서 non-static으로 바로 접근은 불가
		//System.out.println(name);
		
		// 같은 클래스 내에서라도 객체를 생성해서 접근해야 한다
		TestStatic2 t = new TestStatic2();
		System.out.println(t.name);
		t.test1();
		System.out.println(name2); // static member이므로 바로 접근 가능
	}
}
