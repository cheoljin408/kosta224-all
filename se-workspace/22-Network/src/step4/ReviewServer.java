package step4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 	ReviewServer	메세지 output --> ReviewClient 메세지 input
 */
public class ReviewServer {
	public void go() throws IOException {
		ServerSocket serverSocket = null;
		try {
			// 대표전화
			serverSocket = new ServerSocket(5432);
			System.out.println("**ReviewServer**");
			
			while(true) {
				// 대기하다가 클라이언트가 접속하면 동작된다
				// 리턴되는 Socket은 개별 클라이언트와 대화할 상담원 전화기
				Socket socket = serverSocket.accept();
				
				// 클라이언트 ip 찾기
				String clientIp = socket.getInetAddress().toString();
				System.out.println(clientIp + "님 접속");
				
				// true는 autoflush: buffer에 있는 데이터를 즉시 출력
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				out.println(clientIp + "님 즐거운 금요일입니다");
				
				
				// close();
				out.close();
				socket.close();
			}
		} finally {
			if(serverSocket != null)
				serverSocket.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			new ReviewServer().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
