package step1;

public class TestReview {
	public static void main(String[] args) {
		//Market 객체 생성 
		Market m=new Market();
		System.out.println(m.name);//null이 출력,정보가 존재하지 않을때 null 출력
		m.name="G마켓";//객체의 name변수에 정보할당
		System.out.println(m.name);//G마켓
		//라면이라는 인자를 전달한다 ( argument ) 
		//아래 메서드를 호출하면 검색결과가 리턴된다 
		String searchResult=m.searchProduct("라면");
		System.out.println("검색결과:"+searchResult);
	}
}
