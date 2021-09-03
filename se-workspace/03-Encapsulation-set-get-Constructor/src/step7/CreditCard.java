package step7;

public class CreditCard {
	private String info;
	//생성자를 직접 명시해 객체 생성시에 정보를 할당받게 한다 
	//생성자는 객체 초기화 작업이 필요할 때 직접 명시한다 
	//아래의 경우는 신용카드 객체를 만들때 반드시 개인정보를 할당받아서
	//만들도록 생성자의 매개변수를 정의했다 
	public CreditCard(String info) {
		this.info=info;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
