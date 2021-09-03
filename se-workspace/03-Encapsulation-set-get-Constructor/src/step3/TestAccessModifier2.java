package step3;

import step2.Account;

/*
 * step3 팩키지 클래스에서 
 * step2 팩키지 클래스의 멤버에 접근해서
 * 접근제어자를 테스트 해보는 예제 
 * 
 * import : 단축키 ctrl + shift + o 
 * import 는 다른 팩키지의 클래스를 사용하기 위해서 작성하는 구문
 */
public class TestAccessModifier2 {
	public static void main(String[] args) {
		Account a=new Account();
		System.out.println(a.no1);
		//default는 다른 패키지에서는 접근불가
		//System.out.println(a.no2); 
		//private은 자신의 클래스 내에서만 접근가능하므로 접근불가
		//System.out.println(a.no3);
		a.deposit(200);//public 이므로 다른 패키지에서 접근가능
	}
}

