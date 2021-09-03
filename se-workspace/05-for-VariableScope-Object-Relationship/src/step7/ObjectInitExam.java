package step7;

public class ObjectInitExam {
	/*
	 	1.
	 	main의 호출한 메소드로부터 칼국수 7000 정보를 가진 객체의
	 	주소값을 매개변수(지역변수)로 전달받는다.
	 	
	 	2.
	 	pass1 메소드의 매개변수이자 지역변수에
	 	새로운 객체(돈까스 9000 정보를 가진 객체)를 생성해서
	 	새로운 객체의 주소값을 할당한다.
	 	
	 	3.
	 	pass1 메소드가 종료된다.
	 	종료되면 stack 영역에 f 지역변수를 메모리에서 삭제되고
	 	참조한 새 객체(돈까스 9000)는 Garbage Collection에 대상이 된다.
	 */
	public void pass1(Food f) {
		f = new Food("돈까스", 9000);
	}
	
	/*
	 	1.
	 	main의 호출한 메소드로부터 칼국수 7000 정보를 가진 객체의
	 	주소값을 매개변수(지역변수)로 전달받는다.
 	
 		2.
	 	전달받은 객체(칼국수 7000)의 주소값을 가지고 있는 매개변수(지역변수)를
	 	이용해 setName() 메소드를 실행한다.
	 	이때 setName()의 인자값으로 쌀국수 문자열을 전달하는데
	 	이는 main에서 생성한 객체의 인스턴스 변수 정보를 수정하게 된다.
	 	즉, TestObjectInit2의 main의 f 변수와 ObjectInitExam의 pass2의 f 변수는
	 	각각 다른 지역 변수지만 동일한 객체를 참조하고 있으므로 실제 Food의 name이 수정된다.
	 */
	public void pass2(Food f) {
		f.setName("쌀국수");
	}
}
