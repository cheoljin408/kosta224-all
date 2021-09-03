package step1;// 팩키지 : 클래스들을 디렉토리별로 분류하여 관리 

// public : 가장 넓은 범위 접근제어자 access modifier 
public class Market {
	/*
	 *  인스턴스 변수 instance variable -> 객체의 속성 정보를 저장하는 공간 
	 *  String : 문자열 데이터 타입 
	 */
	String name;
	/*
	 * 메서드 : 객체의 기능을 정의 
	 * keyword : 매개변수 parameter 
	 * return 은 정보를 호출한 측으로 반환하기 위해 사용하는 자바 예약어 
	 */
	public String searchProduct(String keyword) {
		System.out.println("DB에서 정보를 조회..");
		return name+":"+keyword+" 상품검색결과->진라면,신라면";
	}
}
