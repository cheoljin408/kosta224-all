package step5;

public class TestVariableScope2 {
	public static void main(String[] args) {
		// sp는 참조변수이자 local variable -> stack memory 영역에 저장
		SmartPhone sp = new SmartPhone();
		System.out.println(sp.getModel()); // null
		System.out.println(sp.getPrice()); // 0
	}
}
