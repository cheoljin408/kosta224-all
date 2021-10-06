package test.pattern;

public class TestSingletonDesignPattern {
	public static void main(String[] args) {
		// private 생성자이므로 compile error
		// CompanyDAO dao = new CompanyDAO();
		
		// public static 메소드를 이용해
		// CompanyDAO 객체의 주소값을 반환받는다
		System.out.println(CompanyDAO.getInstance());
		System.out.println(CompanyDAO.getInstance());
		System.out.println(CompanyDAO.getInstance());
		
		// CompanyDAO의 getCompanyInfo()를 호출해서
		// companyInfo를 반환받아 콘솔에 출력해본다
		System.out.println(CompanyDAO.getInstance().getCompanyInfo());
	}
}
