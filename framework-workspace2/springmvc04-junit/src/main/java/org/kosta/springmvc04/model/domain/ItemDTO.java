package org.kosta.springmvc04.model.domain;

public class ItemDTO {
	private int itemNo;
	private String name;
	private String maker;
	private int price;
	private String regDate;
	
	public ItemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ItemDTO(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
	}

	public ItemDTO(int itemNo, String name, String maker, int price) {
		super();
		this.itemNo = itemNo;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemDTO [itemNo=" + itemNo + ", name=" + name + ", maker=" + maker + ", price=" + price + ", regDate="
				+ regDate + "]";
	}
	
	
	
}
