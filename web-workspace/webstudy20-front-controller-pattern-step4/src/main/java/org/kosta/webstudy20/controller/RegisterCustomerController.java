package org.kosta.webstudy20.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy20.model.MockDAO;

public class RegisterCustomerController implements Controller {

	/*
	 	index의 등록 폼에서 전달한 customerInfo를 받아온다
	 	MockDAO의 registerCustomer()를 이용해 등록한다
	 	결과화면을 보여주기 위해 register-result.jsp로 redirect방식으로 응답하기 위해 return 한다
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resonse) throws Exception {
		String customerInfo = request.getParameter("customerInfo");
		MockDAO.getInstance().registerCustomer(customerInfo);
		
		return "redirect:register-result.jsp";
	}

}
