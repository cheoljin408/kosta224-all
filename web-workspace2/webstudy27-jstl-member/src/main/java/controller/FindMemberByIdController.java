package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberByIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId = request.getParameter("memberId");
		MemberVO vo = MemberDAO.getInstance().findMemberById(memberId);
		
		String path = null;
		if(vo == null) {
			path = "findbyid-fail.jsp";
		}
		else {
			path = "findbyid-ok.jsp";
			request.setAttribute("memberVO", vo);
		}
		
		return path;
	}

}
