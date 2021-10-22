package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

public class FindMemberListByAddressController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String address = request.getParameter("address");
		ArrayList<MemberVO> list = MemberDAO.getInstance().findMemberListByAddress(address);
		
		String path = null;
		if(list == null) {
			path = "findbyaddress-fail.jsp";
		}
		else {
			path = "findbyaddress-ok.jsp";
			request.setAttribute("memberList", list);
		}
		
		return path;
	}

}
