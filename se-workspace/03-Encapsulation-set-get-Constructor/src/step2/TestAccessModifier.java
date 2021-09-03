package step2;
/*
 * 접근 제어자 테스트 
 */
public class TestAccessModifier {
	public static void main(String[] args) {
		Account a=new Account();
		//public 에 접근해서 출력해본다 
		System.out.println(a.no1);//정수형이므로 0으로 초기화
		a.no1=1111;//할당
		System.out.println(a.no1);//1111
		//default 에 접근해본다 
		a.no2=2222; // 동일한 팩키지이므로 접근 가능 
		System.out.println(a.no2);
		//private에 접근해본다 
		//private은 다른 클래스에서 접근불가하므로 아래 코드는 
		//compile error가 난다 
		//a.no3=3333;
	}
}
