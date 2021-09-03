package step7.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	/*
	 	ServerScoket ����
	 	loop
	 	accept()
	 	ServerWorker ����
	 	Thread ����
	 	start()
	 */
	// client�� ����� �ϴ� ��ü(ServerWorker > socket)�� ����Ʈ�� ����
	private ArrayList<ServerWorker> list = new ArrayList<ServerWorker>();
	
	public void go() throws IOException {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("**ChatServer**");
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerWorker serverWorker = new ServerWorker(socket);
				
				list.add(serverWorker);
				
				Thread thread = new Thread(serverWorker);
				thread.start();
			}
		} finally {
			if(serverSocket != null)
				serverSocket.close();
		}
	}
	
	/*
	 	������ ServerWorker�� Ŭ���̾�Ʈ�κ��� �Է¹��� �޼�����
	 	������ ��ü Ŭ���̾�Ʈ���� ����ϱ� ���� �޼ҵ�
	 	�Ʒ� �޼ҵ带 ���� ServerWorker�� run �޼ҵ忡�� ȣ���ؼ� ����Ѵ�
	 */
	public void sendMessage(String message) {
		// for loop�� �̿��� list�� �ִ� ��� ServerWorker�� pw.println();
		for(int i=0; i<list.size(); i++) {
			list.get(i).pw.println(list.get(i).clientIp + "��:" + message);
		}
	}
	
	// nested class
	public class ServerWorker implements Runnable {
		private Socket socket;
		private String clientIp;
		private BufferedReader br;
		private PrintWriter pw;
		
		public ServerWorker(Socket socket) {
			super();
			this.socket = socket;
			this.clientIp = socket.getInetAddress().toString();
			
			System.out.println(clientIp + "�� �����ϼ̽��ϴ�!");
			sendMessage(clientIp + "�� �����ϼ̽��ϴ�!");
		}

		@Override
		public void run() {
			try {
				chatting();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void chatting() throws IOException {
			br = null; // client message �� �Է�
			pw = null; // client message�� ���
			
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream(), true);
				while(true) {
					String message = br.readLine();
					if(message == null || message.equalsIgnoreCase("exit")) {
						break; // while���� ����
					}
					System.out.println(clientIp + ":" + message);
					sendMessage(message);
				}
			} finally {
				list.remove(this);
				System.out.println(clientIp + "���� �����ϼ̽��ϴ�");
				sendMessage(clientIp + "���� �����ϼ̽��ϴ�");
				
				if(br != null)
					br.close();
				if(pw != null)
					pw.close();
				if(socket != null)
					socket.close();
			}	
		}
		
	}
	
	public static void main(String[] args) {
		try {
			new ChatServer().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
