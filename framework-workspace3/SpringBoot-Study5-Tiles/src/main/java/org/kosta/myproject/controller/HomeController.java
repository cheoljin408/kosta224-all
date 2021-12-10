package org.kosta.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		// db, model 과 연동 
		// tiles-config.xml 에 정의된 definition name인 home.tiles를 이용해
		// view를 제공 
		return "home.tiles";
	}
	//
	
	@RequestMapping("main2")
	public String main2() {
		return "main2.tiles";
	}
	
	@RequestMapping("main3")
	public String main3() {
		return "main3.tiles";
	}
	
	// tiles를 적용하지 않는 일반 jsp를 응답
	@RequestMapping("noneTiles")
	public String noneTile() {
		// .tiles 명시하지 않았으므로 일반 jsp로 응답
		// InternalResourceViewResolver 가 동작됨
		return "noneTiles";
	}
}







