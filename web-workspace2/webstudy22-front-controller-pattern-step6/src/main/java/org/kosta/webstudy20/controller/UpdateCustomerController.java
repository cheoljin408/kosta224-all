package org.kosta.webstudy20.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy20.model.MockDAO;

public class UpdateCustomerController implements Controller {

	/*
	 	client로부터 수정할 고객정보를 받아온다
	 	MockDAO의 updateCustomer()를 호출해 db에 업데이트 시킨다
	 	redirect 방식으로 update-result.jsp를 클라이언트에게 응답한다
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resonse) throws Exception {
		String customerInfo = request.getParameter("customerInfo");
		MockDAO.getInstance().updateCustomer(customerInfo);
		
		return "redirect:update-result.jsp";
	}

}
