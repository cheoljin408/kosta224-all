package step6;

// 모든 자바 클래스의 최상위 부모 클래스인 java.lang.Object의 toString()을 확인하고, 오버라이딩 해보는 예제

class Food { // extends Object
	// Food() { super(); }
}

class Food2 {
	String menu;
	int price;
	
	Food2(String menu, int price) {
		// super();
		this.menu = menu;
		this.price = price;
	}
	
	// Object 부모 클래스의 toString() 메소드를 오버라이딩해서 주소값 대신 객체의 실제 정보가 반환되게 한다.
	public String toString() {
		return "menu:" + menu + " price:" + price;
		}
}

public class TestObject2 {
	public static void main(String[] args) {
		Food f1 = new Food();
		System.out.println(f1.toString()); // 부모 클래스 Object의 toString()을 호출해서 객체의 주소값을 반환
		System.out.println(f1); // println 메소드에서 참조형 데이터 즉 객체가 전달되면 내부적으로 toString()을 호출한 값을 출력
		
		Food f2 = new Food();
		System.out.println(f2.toString());
		System.out.println(f2); // toString()을 호출하지 않아도 println() 메소드 내부적으로 호출하여 값을 출력, 결과적으로 동일
		
		System.out.println("*****Object의 toString()을 오버라이딩해서 테스트해본다.*****");
		
		Food2 fo1 = new Food2("한맥", 2000);
		System.out.println(fo1);
		Food2 fo2 = new Food2("테라", 2100);
		System.out.println(fo2);
	}
}
