package step6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.CarDAO;
import model.CarDTO;

/**
 * Servlet implementation class JSONArrayServlet
 */
@WebServlet("/JSONArrayServlet2")
public class JSONArrayServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		JSONArray ja = new JSONArray();
		ja.put("김밥");
		ja.put("라면");
		ja.put("콜라");
		
		ArrayList<CarDTO> list = CarDAO.getInstance().getCarList("현대");
		ja = new JSONArray(list);
		out.print(ja.toString());
		out.close();
	}

}
