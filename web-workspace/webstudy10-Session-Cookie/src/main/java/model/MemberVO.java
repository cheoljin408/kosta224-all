package model;

import java.io.Serializable;

/*
 	implements Serializable: 세션에 저장되는 MemberVO 객체가 서버 reload(stop) 시에 직렬화되오 저장되기 위해
 */
public class MemberVO implements Serializable {
	private static final long serialVersionUID = 2379128892442727379L;
	private String id;
	private String password;
	private String name;
	private String address;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
}
