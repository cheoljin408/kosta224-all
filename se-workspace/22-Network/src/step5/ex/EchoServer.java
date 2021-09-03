package step5.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	/*
	 	������ Ŭ���̾�Ʈ�� ������ ���(1 �� 1 ����̹Ƿ� accept() �ݺ� x)
	 	1. ������ Ŭ���̾�Ʈ�� ���� �޼����� �Է¹޾� �ڽ��� �ֿܼ� ��� (BufferedReader)
	 	2. �Է¹��� �޼����� �ٽ� Ŭ���̾�Ʈ�� ����Ѵ�(*server*�� ���ڿ� ���� �߰�)
	 	
	 	1, 2�� �ݺ�
	 	(Ŭ���̾�Ʈ�� "����"��� ���ڿ��� ������ ���� �ڽŵ� ���α׷��� �����Ѵ�
	 	
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
					System.out.println("**EchoClient �����մϴ�**");
					out.close();
					br.close();
					socket.close();
					break;
				}
				System.out.println("Ŭ���̾�Ʈ�� ���� �޼���:" + message);
				
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
