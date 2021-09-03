package step3.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer3 {
	/*
	 	서버는 접속 대기하다가
	 	클라이언트 접속해서 메세지를 출력하면
	 	그 메세지를 입력받고
	 	자신의 콘솔에 메세지를 출력한 후
	 	해당 클라이언트와의 접속을 종료(close)
	 	후 다시 반복
	 */
	public void go() throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("**NetServer3 실행**");
			
			Socket socket = serverSocket.accept();
			String clientIp = socket.getInetAddress().toString();
			System.out.println("**" + clientIp +" client 접속됨**");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = br.readLine();
			System.out.println("클라이언트가 보낸 메세지:" + message);
			
			br.close();
			socket.close();
			System.out.println("**NetServer3 종료**");
		} finally {
			if(serverSocket != null)
				serverSocket.close();
		}
	}
	public static void main(String[] args) {
		try {
			new NetServer3().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
