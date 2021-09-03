package step4;

interface Flyer{}

class Bird implements Flyer{}

class Eagle extends Bird {} // 부모 클래스인 Bird가 implements 했으므로 Eagle 또한 Flyer 계층 구조의 하위 클래스가 된다

public class TestInterface {
	public static void main(String[] args) {
		Flyer f1 = new Bird();
		Flyer f2 = new Eagle();
		System.out.println(f1);
		System.out.println(f2);
	}
}
