package org.kosta.webstudy21.controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	
	private HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		return instance;
	}
	
	public Controller create(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// 패키지명을 받아온다
		String packageInfo = this.getClass().getPackage().getName();
		
		// 클래스명을 패키지명에 추가한다
		String classInfo = new StringBuilder(packageInfo).append("." + command).toString();
		System.out.println(classInfo);
		
		// 동적으로 컨트롤러 객체를 생성해 FrontControllerServlet으로 리턴한다
		return (Controller) Class.forName(classInfo).newInstance();
	}
}
