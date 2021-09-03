package step2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 	클라이언트가 여러번 접속해도 동작될 수 있도록 step1 서버를 업데이트
 	ServerSocket 생성
 	while(true) {
 		Socket socket = serverSocket.accept(); // 클라이언트가 여러번 접속할 수 있도록 accept() 를 반복해서 실행
 		출력 서비스
 		close
 	}
 */
public class NetServer2 {
	public void go() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("**NetServer2 실행**");
		
			int count = 1;
			while(true) {
				Socket socket = serverSocket.accept();
				String clientIp = socket.getInetAddress().toString();
				System.out.println("**" + clientIp + " client 접속됨, 접속수:" + count);
				
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.println(clientIp + "님 즐거운 목요일 오후" + count++);
				System.out.println(clientIp + "client에게 메세지 출력");
				
				out.close();
				socket.close();	
			}
		} finally {
			if(serverSocket != null)
				serverSocket.close();
		}
	}
	
	public static void main(String[] args) {
		NetServer2 server = new NetServer2();
		try {
			server.go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
