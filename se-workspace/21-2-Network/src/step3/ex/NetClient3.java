package step3.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import common.IP;

public class NetClient3 {
	/*
	 	client�� ������ ����(Socket ����) - Local ip�� ����
	 	������ �޼����� ���(socket.getOutputStream() < PrintWriter println())
	 	out�� socket close
	 */
	public void go() throws UnknownHostException, IOException {
		Socket socket = new Socket(IP.LOCAL, 5432);
		System.out.println("**NetClient3�� ������ ������**");
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println("Ŭ���̾�Ʈ -> ����");
		System.out.println("������ �޼��� ���");
		
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
