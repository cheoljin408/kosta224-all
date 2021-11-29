package org.kosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/*
	@RequestMapping("home.do")
	public ModelAndView home() {
		return new ModelAndView("index", "message", "Hello SpringMVC!");
	}
	*/
	
	@RequestMapping("home.do")
	public String home(Model model) {
		model.addAttribute("message", "Hello SpringMVC 즐거운 한 주~");
		// spring-servlet.xml의 viewResolver설정에 의해
		// 리턴하는 view name은 /WEB-INF/views/index.jsp로 찾아서 응답하게 된다
		return "index";
	}
}
