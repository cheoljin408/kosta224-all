package org.kosta.myboard.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myboard.model.BoardDAO;
import org.kosta.myboard.model.PostVO;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<PostVO> postList = null;
		postList = BoardDAO.getInstance().getPostingList();
		request.setAttribute("postList", postList);
		// template layout 페이지를 이용해 리스트 화면을 제공
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}
	
}
