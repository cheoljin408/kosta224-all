package step5.ex;

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
		System.out.println("**EchoClient**");
		Socket socket = new Socket(IP.INST, 5432);
		Scanner scanner = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter out = null;
		
		while(true) {
			out = new PrintWriter(socket.getOutputStream(), true);
			System.out.print("서버로 보낼 메세지:");
			String message = scanner.nextLine();
			out.println(message);
			if(message.equals("exit")) {
				System.out.println("**EchoClient 종료합니다**");
				br.close();
				scanner.close();
				out.close();
				socket.close();
				break;
			}
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String messageFromServer = br.readLine();
			System.out.println(messageFromServer);
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
