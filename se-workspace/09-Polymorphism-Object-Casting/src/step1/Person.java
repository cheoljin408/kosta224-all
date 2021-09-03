package step1;

public class Person extends Animal {
	@Override // @: 어노테이션(의미있는 주석, 컴파일과 런타임에 영향을 준다)
	// @Override: 메소드 오버라이딩 시 컴파일 시점에 오버라이드 문법을 체크
	public void eat() { // 메소드 오버라이딩은 부모 메소드를 자신에 맞게 재정의 해준다
		System.out.println("사람이 수저로 먹다");
	}
}
