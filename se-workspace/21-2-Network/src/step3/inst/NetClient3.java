package step3.inst;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import common.IP;

public class NetClient3 {
	/*
	 * client는 서버에 접속(Socket 생성) - Local ip로 연습 서버로 메세지를 출력(socket.getOutputStream()
	 * < PrintWriter println()) out과 socket close
	 */
	public void go() throws UnknownHostException, IOException {
		Scanner scanner = new Scanner(System.in);
		Socket socket = new Socket(IP.INST, 5432);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // autoflush, buffer에 있는 데이터를 즉시 출력
		System.out.print("서버에 보낼 메세지: ");
		String message = scanner.nextLine();
		out.println(message);
		System.out.println("**서버로 메세지 전송**");
		
		scanner.close();
		out.close();
		socket.close();
	}
	
	public static void main(String[] args) {
		try {
			new NetClient3().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
