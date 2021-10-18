package test;

public class TestString {
	public static void main(String[] args) {
		String uri="/webstudy22-front-do-unit-test/FindController.do";
		// 위 uri에서 context path인 /webstudy22-front-do-unit-test와 .do를 제외한 문자열을 추출 -> FindController
		String contextPath ="/webstudy22-front-do-unit-test";
		System.out.println(contextPath.length());
		System.out.println(uri.substring(contextPath.length()+1)); // FindController.do
		
		String name = "디카프리오";
		System.out.println(name.substring(2, 4)); // beginIndex 2부터 4앞까지 이므로 "프리"
		
		System.out.println(uri.substring(contextPath.length()+1, uri.length()-3));
	}
}
