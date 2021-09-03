package step5.inst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import common.IP;

public class EchoClient {
	/*
	 	서버에 접속하여
	 	1. 콘솔에서 입력 (Scanner)
	 	2. 서버로 출력 (PrintWriter)
	 	3. 다시 서버에서 보낸 메세지를 입력 (BufferedReader) 받아 콘솔에 출력
	 	
	 	1, 2, 3을 반복 ("종료" 문자열을 콘솔에 입력하면 클라이언트 프로그램이 종료되도록 한다)
	 */
	public void go() throws UnknownHostException, IOException {
		Socket socket = null; // 서버와 통신
		Scanner scanner = null; // 콘솔에 입력
		PrintWriter out = null; // 서버로 출력
		BufferedReader br = null; // 서버에서 입력
		try {
			socket = new Socket(IP.LOCAL, 5432);
			scanner = new Scanner(System.in);
			out = new PrintWriter(socket.getOutputStream(), true); // autoflush 즉시 출력
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("**EchoClient가 서버에 접속**");
			
			while(true) {
				System.out.print("서버에 보낼 메세지:");
				String message = scanner.nextLine(); // 사용자로부터 콘솔에서 메세지를 입력받는다
				out.println(message); // 서버로 메세지를 보낸다
				if(message.equalsIgnoreCase("exit")) {
					System.out.println("**EchoClient 종료합니다**");
					break;
				}
				String response = br.readLine(); // 서버에서 보낸 메세지를 입력받는다
				System.out.println("서버에서 입력받은 메세지:" + response);
			}
			
		} finally {
			if(br != null)
				br.close();
			if(out != null)
				out.close();
			if(scanner != null)
				scanner.close();
			if(socket != null)
				System.out.println("*socket close*");
				socket.close();
		}
	}	
	
	public static void main(String[] args) {
		try {
			new EchoClient().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
