package org.kosta.webstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy21.model.MockDAO;

public class FindProductByIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("productId");
		String productInfo = MockDAO.getInstance().findProductById(id);
		
		String path = null;
		if(productInfo == null) {
			path = "find-fail.jsp";
		}
		else {
			request.setAttribute("productInfo", productInfo);
			path = "find-ok.jsp";
		}
		return path;
	}

}
