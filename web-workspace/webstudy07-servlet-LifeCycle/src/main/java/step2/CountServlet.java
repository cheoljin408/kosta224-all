package step2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "C:\\kosta224\\iotest\\count";
    private int count;
    
    public CountServlet() {
        super();
        System.out.println("CountServlet 객체 생성");
    }
    
	@Override
	public void init() throws ServletException {
		File countFile = new File(path);
		if(countFile.isFile()) {
			try {
				DataInputStream dis = new DataInputStream(new FileInputStream(countFile));
				count = dis.readInt();
				dis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			count++;
		}
		System.out.println("init() 실행");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h3>CountServlet service 계열 method 실행");
		out.println(" 접속수:" + count + "</h3>");
		count++;
		
		out.close();
	}

	@Override
	public void destroy() {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
			dos.writeInt(count);
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("destroy 실행-조회수 백업");
	}

	
}
