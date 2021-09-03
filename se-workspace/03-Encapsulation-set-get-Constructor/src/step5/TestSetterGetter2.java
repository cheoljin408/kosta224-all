package step5;

public class TestSetterGetter2 {
	public static void main(String[] args) {
		Person p=new Person();
		//setter getter를 tool로 만들어 보고 
		//활용해본다 
		p.setAddress("수지구");
		p.setId("tico99");
		p.setNickName("정우썽");
		p.setMoney(100);
		p.setName("서정우");
		System.out.println(p.getAddress()+" "+p.getId()+" "
		+p.getNickName()+" "+p.getMoney()+" "+p.getName());
	}
}
