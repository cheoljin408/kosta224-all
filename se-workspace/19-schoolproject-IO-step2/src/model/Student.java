package model;

public class Student extends Member {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1470242383181143598L;
	private String stuNo;

	public Student(String tel, String name, String address, String stuNo) {
		super(tel, name, address);
		this.stuNo = stuNo;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	@Override
	public String toString() {
		return super.toString() + ", stuNo=" + stuNo;
	}
	
	
}
