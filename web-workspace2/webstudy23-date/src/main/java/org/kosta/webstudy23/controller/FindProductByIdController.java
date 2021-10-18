package org.kosta.webstudy23.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy23.model.ProductDAO;
import org.kosta.webstudy23.model.ProductVO;

public class FindProductByIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String productId = request.getParameter("productId");
		ProductVO result = ProductDAO.getInstance().findProductById(productId);
		
		String path = null;
		if(result == null) {
			path = "findbyid-fail.jsp";
		}
		else {
			request.setAttribute("productVO", result);
			path = "findbyid-ok.jsp";
		}
		
		return path;
	}

}
