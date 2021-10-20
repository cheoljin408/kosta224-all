package model;
// JSP EL에서 접근해 사용가능한 메서드는 get계열의 메서드와 is 계열 메서드만 가능 
public class TestVO {	
	//JSP EL에서 접근가능 
	public String getName() {
		System.out.println("TestVO getName() 실행");
		return "아이유";
	}
	//EL에서 접근불가 , get 과 is 계열의 메서드 외는 접근 불가 
	public String findInfo() {
		return "짜장면";
	}
	//EL에서 접근가능
	public boolean isExist() {
		return false;
	}	
}
