package org.kosta.webstudy20.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy20.model.MockDAO;

public class DeleteCustomerController implements Controller {

	/*
	 	client가 보낸 고객 아이디를 반환받는다
	 	MockDAO의 deleteCustomer 메소드를 실행한다
	 	delete-result.jsp로 리다이렉트 한다
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resonse) throws Exception {
		String customerId = request.getParameter("customerId");
		MockDAO.getInstance().deleteCustomer(customerId);
		return "redirect:delete-result.jsp";
	}

}
