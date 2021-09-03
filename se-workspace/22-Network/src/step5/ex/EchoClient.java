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
	 	������ �����Ͽ�
	 	1. �ֿܼ��� �Է� (Scanner)
	 	2. ������ ��� (PrintWriter)
	 	3. �ٽ� �������� ���� �޼����� �Է� (BufferedReader) �޾� �ֿܼ� ���
	 	
	 	1, 2, 3�� �ݺ� ("����" ���ڿ��� �ֿܼ� �Է��ϸ� Ŭ���̾�Ʈ ���α׷��� ����ǵ��� �Ѵ�)
	 */
	public void go() throws UnknownHostException, IOException {
		System.out.println("**EchoClient**");
		Socket socket = new Socket(IP.INST, 5432);
		Scanner scanner = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter out = null;
		
		while(true) {
			out = new PrintWriter(socket.getOutputStream(), true);
			System.out.print("������ ���� �޼���:");
			String message = scanner.nextLine();
			out.println(message);
			if(message.equals("exit")) {
				System.out.println("**EchoClient �����մϴ�**");
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
