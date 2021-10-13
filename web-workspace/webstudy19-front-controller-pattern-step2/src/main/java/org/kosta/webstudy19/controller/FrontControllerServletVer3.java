package org.kosta.webstudy19.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy19.model.MockDAO;

/**
 * Front Controller Design Pattern 적용 모든 클라이언트의 요청을 하나의 진입점으로 통합하여 처리하는 디자인 패턴
 * FrontControllerServlet: 모든 클라이언트 요청을 처리하는 서블릿
 * 
 * Ver2 작업
 * doDispatch 메소드의 처리 작업이 많으므로 기능별로 메소드를 분할하여 호출해 요청을 처리하는 방식으로 구조를 개선
 * 
 * Ver3에서는 컨트롤러 로직을 담당하는 메소드를 별도의 클래스로 분화시키고
 * 요청처리에 대한 캡슐화, 인터페이스를 통한 업무의 표준화, FrontControllerServletVer3와 개별 컨트롤러 객체와의
 * 결합도를 낮추기 위해 Controller Interface를 추가하고 개별 컨트롤러 로직을 담당하는 객체들은 Controller Interface 계층 구조의
 * 하위로 편입되도록 한다
 * FrontControllerServletVer3은 개별 컨트롤러 클래스가 아니라 상위 인터페이스인 Controller의 abstract method를 이용해
 * 컨트롤러 로직을 실행한다	
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServletVer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 다양한 클라이언트의 요청을 구분하기 위해 command를 받아온다
			String command = request.getParameter("command");
			Controller controller = null;
			
			if (command.equals("findCarByNo")) {
				controller = new FindCarByNoController();
			}
			else if(command.equals("findCarListByMaker")) {
				controller = new FindCarListByMakerController();
			}
			else if(command.equals("registerCar")) {
				controller = new RegisterCarController();
			}
			
			// 인터페이스를 통한 계층구조 형성으로 단일한 메세지 방식(execute())으로 다양한 컨트롤러 구현체들을 실행할 수 있다
			String path = controller.execute(request, response);
			// path가 redirect: 으로 시작되면 redirect 방식으로 응답한다
			if(path.startsWith("redirect:")) {
				response.sendRedirect(path.substring(9));
			}
			else {
				request.getRequestDispatcher(path).forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// Exception 발생할 경우 클라이언트에게 error.jsp를 제공한다
			response.sendRedirect("error.jsp");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post방식은 http request body 영역의 별도의 인코딩 처리가 필요하다
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}

}
