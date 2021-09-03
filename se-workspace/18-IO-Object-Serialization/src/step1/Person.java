package step1;

import java.io.Serializable;

// Person class로부터 생성된 객체가 직렬화(전송 상태)되기 위해서는 
// 아래와 같이 Serializable interface를 implements해야 한다
public class Person implements Serializable {
	/**
	 * 이 후 유지보수성을 위해 아이디를 생성한다
	 */
	private static final long serialVersionUID = 9160681603708373621L;
	private String name;
	private String address;
	private int money;
	// 인스턴스 변수 추가
	private String hobby;

	public Person(String name, String address, int money) {
		super();
		this.name = name;
		this.address = address;
		this.money = money;
	}

	public Person(String name, String address, int money, String hobby) {
		super();
		this.name = name;
		this.address = address;
		this.money = money;
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", money=" + money + "]";
	}

}
