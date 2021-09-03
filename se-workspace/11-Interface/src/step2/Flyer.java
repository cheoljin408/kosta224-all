package step2;

public interface Flyer {
	String ID = "javaking"; // public static final 상수로 자동 인식
	// compile error, 인터페이스는 구현된 메소드를 가질 수 없다
	// public void test() {}
	public void fly(); // abstract를 명시하지 않아도 abstract method로 자동 인식
}
