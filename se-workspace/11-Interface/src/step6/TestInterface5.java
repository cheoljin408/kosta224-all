package step6;

interface OpenInterface {
	public void a();
	// public void b(); // 일반 구현 메소드를 가질 수 없다
	
	// jdk 1.8 이상에서는 default 메소드가 지원 -> 유지보수성 차원
	public default void newMethod() {}
	
	// jdk 1.8 이상에서는 static 메소드가 지원
	public static void sMethod() {}
}

class KbBank implements OpenInterface {
	@Override
	public void a() {}
	
	@Override
	public void newMethod() {
		// 디폴트 메소드 오버라이딩 가능
	}
}

class KakaoBank implements OpenInterface {
	@Override
	public void a() {}
}

public class TestInterface5 {
	
}
