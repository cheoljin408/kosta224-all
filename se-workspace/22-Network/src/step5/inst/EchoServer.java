package step5.inst;

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
		ServerSocket serverSocket = null; // 대표전화
		Socket socket = null; // 상담원 전화
		BufferedReader br = null; // 클라이언트의 메세지를 입력
		PrintWriter out = null; // 클라이언트에세 메세지를 출력
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("**EchoServer**");
			socket = serverSocket.accept();
			String clientIp = socket.getInetAddress().toString();
			System.out.println(clientIp + "님이 입장하셨습니다");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				String message = br.readLine(); // 클라이언트가 보낸 메세지를 입력받는다
				if(message == null || message.equals("exit")) {
					System.out.println(clientIp + "님이 나가셨습니다");
					break;
				}
				System.out.println(clientIp + "님의 메세지:" + message);
				out.println(message + "*server*"); // 클라이언트로 메세지를 출력한다
			}
			
		} finally {
			System.out.println("**EchoServer 종료**");
			if(out != null)
				out.close();
			if(br != null)
				br.close();
			if(socket != null)
				socket.close();
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
