package step5;

public class FriendDTO {
	private String name;
	private int money;
	public FriendDTO(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "FriendDTO [name=" + name + ", money=" + money + "]";
	}
	
	
}
