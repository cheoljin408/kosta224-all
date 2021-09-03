package step5;

public class TestPolymorphism6 {
	public static void main(String[] args) {
		CompanyService service=new CompanyService();
		service.printDetailInfo(new Manager("1","아이유",500,"영업부"));
		//empNo:1 name:아이유 salary:500 department:영업부
		service.printDetailInfo(new Engineer("2","고슬링",700,"java"));
		//empNo:2 name:고슬링 salary:700 skill:java
		service.printDetailInfo(new Employee("3","옹성우",400));
		//empNo:3 name:옹성우 salary:400 
	}
}
