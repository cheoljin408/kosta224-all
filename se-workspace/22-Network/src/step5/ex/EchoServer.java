package step5.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	/*
	 	서버는 클라이언트의 접속을 대기(1 대 1 통신이므로 accept() 반복 x)
	 	1. 서버는 클라이언트가 보낸 메세지를 입력받아 자신의 콘솔에 출력 (BufferedReader)
	 	2. 입력받은 메세지를 다시 클라이언트로 출력한다(*server*를 문자열 끝에 추가)
	 	
	 	1, 2을 반복
	 	(클라이언트가 "종료"라는 문자열을 보내면 서버 자신도 프로그램을 종료한다
	 	
	 */
	public void go() throws IOException {
		System.out.println("**EchoServer**");
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5432);
			Socket socket = serverSocket.accept();
			BufferedReader br = null;
			PrintWriter out = null;
			
			while(true) {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String message = br.readLine();
				if(message.equals("exit")) {
					System.out.println("**EchoClient 종료합니다**");
					out.close();
					br.close();
					socket.close();
					break;
				}
				System.out.println("클라이언트가 보낸 메세지:" + message);
				
				out = new PrintWriter(socket.getOutputStream(), true);
				out.println(message + "*server*");
			}
		} finally {
			if(serverSocket != null)
				serverSocket.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			new EchoServer().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
