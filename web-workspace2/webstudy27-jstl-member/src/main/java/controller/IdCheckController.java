package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;

public class IdCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		boolean result = MemberDAO.getInstance().idCheck(id);
		
		String path = null;
		if(result) {
			path = "idcheck-fail.jsp";
		}
		else {
			path = "idcheck-ok.jsp";
		}
		return path;
	}

}
