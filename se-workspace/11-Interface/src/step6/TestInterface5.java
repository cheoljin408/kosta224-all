package step6;

interface OpenInterface {
	public void a();
	// public void b(); // �Ϲ� ���� �޼ҵ带 ���� �� ����
	
	// jdk 1.8 �̻󿡼��� default �޼ҵ尡 ���� -> ���������� ����
	public default void newMethod() {}
	
	// jdk 1.8 �̻󿡼��� static �޼ҵ尡 ����
	public static void sMethod() {}
}

class KbBank implements OpenInterface {
	@Override
	public void a() {}
	
	@Override
	public void newMethod() {
		// ����Ʈ �޼ҵ� �������̵� ����
	}
}

class KakaoBank implements OpenInterface {
	@Override
	public void a() {}
}

public class TestInterface5 {
	
}
