package org.kosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyTestController {
	
	@RequestMapping("hello.do")
	public ModelAndView myTest() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result1");
		mv.addObject("info", "Hello SpringMVC");
		return mv;
	}
	
	// 위의 컨트롤러 개발 스타일을 아래와 같이 표현할 수도 있다
	@RequestMapping("hi.do")
	public String hi(Model model) {
		model.addAttribute("info", "Hi SpringMVC");
		return "result1";
	}
	
	// @RequestParam: request.getParameter()의 역할
	// HandlerAdapter(RequestMappingHandlerAdapter)가 컨트롤러 실행시
	// 매개변수에 알맞는 데이터를 생성해 전잘해준다
	// @RequestParam은 매개변수명이 form data의 name과 일치한다면 생략이 가능
	@RequestMapping("paramTest1.do")
	public String paramTest1(String customerId, Model model) {
//	public String paramTest1(@RequestParam String customerId, Model model) {
		model.addAttribute("customerName", "아이유");
		return "result2";
	}
	
	@RequestMapping("paramTest2.do")
	public String paramTest2(String userName, String userAddress, Model model) {
		model.addAttribute("message", "고객정보 등록 완료");
		return "result3";
	}
	
	@RequestMapping("paramTest3.do")
	public String paramTest3(String[] hobby) {
		for(int i=0; i<hobby.length; i++) {
			System.out.println(hobby[i]);
		}
		return "result4";
	}
	
	// spring4.3 버전 미만일 때는 아래와 같이 요청방식을 제한할 수 있다
	// post방식만 지원
	@RequestMapping(method=RequestMethod.POST, value="methodTest1.do")
	public String methodTest1() {
		System.out.println("post 방식");
		return "result4";
	}
	
	// spring4.3 버전 이상일 때는 아래와 같이 더 간단하게 요청방식을 제한할 수 있다
	@PostMapping("methodTest2.do")
	public String methodTest2() {
		
		return "result4";
	}
	
	
}
