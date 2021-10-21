package model;

public class MemberVO {
	private String id;
	private String passowrd;
	private String name;
	private String address;
	private String birthday;
	private String regdate;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String passowrd, String name, String address, String birthday, String regdate) {
		super();
		this.id = id;
		this.passowrd = passowrd;
		this.name = name;
		this.address = address;
		this.birthday = birthday;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passowrd=" + passowrd + ", name=" + name + ", address=" + address
				+ ", birthday=" + birthday + ", regdate=" + regdate + "]";
	}
	
	
	
}
