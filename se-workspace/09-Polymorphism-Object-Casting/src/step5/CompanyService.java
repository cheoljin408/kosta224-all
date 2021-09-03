package step5;

public class CompanyService {
	public void printDetailInfo(Employee e) {
		System.out.println(e.printDetail());
		
		// toString 메소드를 오버라이딩 했으므로 아래와 같이 출력하면 된다.
		System.out.println(e);
	}
}
