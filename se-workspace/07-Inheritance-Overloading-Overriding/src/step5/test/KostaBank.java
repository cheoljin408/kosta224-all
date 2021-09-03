package step5.test;
import step5.access.Bank;

public class KostaBank extends Bank {
	public void test() {
		publicTest(); // public이므로 다른 패키지에서 접근 가능
		protectedTest(); // 다른 패키지 이지만 상속받았으므로 protected method에 접근 가능
		// defaultTest(); // default method는 다른 패키지에서 접근 불가
		// privateTest(); // private method는 자신의 클래스 내에서만 접근 가능하므로 접근 불가
	}
}
