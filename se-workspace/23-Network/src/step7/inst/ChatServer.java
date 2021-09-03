package step7.inst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
	/*
	 *  ServerSocket ����  
	 *  loop  
	 *  accept() 
	 *  ServerWorker ���� 
	 *  list.add(ServerWorker) 
	 *  Thread ���� 
	 *  start() 
	 */
	// client�� ����� �ϴ� ��ü(ServerWorker>socket)�� ����Ʈ�� ����  
	// �ټ��� ServerWorker Thread�� ���� �����Ǿ� ���Ǵ� ����Ʈ�̹Ƿ� thread-safe �ϰ� ó���غ���(����ȭ ó��)
	// private ArrayList<ServerWorker> list=new ArrayList<ServerWorker>();
	private List<ServerWorker> list = Collections.synchronizedList(new ArrayList<ServerWorker>());
	
	public void go() throws IOException {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("**ChatServer ����**");
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerWorker serverWorker = new ServerWorker(socket);
				
				// list�� �߰�
				list.add(serverWorker);
				
				Thread serverWorkerThread = new Thread(serverWorker);
				serverWorkerThread.start();
			}
		} finally {
			if(serverSocket != null)
				serverSocket.close();
		}
	}
	
	/*
	 *  ������ ServerWorker�� Ŭ���̾�Ʈ�κ��� �Է¹��� �޼����� 
	 *  ������ ��ü Ŭ���̾�Ʈ���� ����ϱ� ���� �޼��� 
	 *  �Ʒ� �޼��带 ���� ServerWorker�� run �޼��忡�� ȣ���ؼ� ����Ѵ� 
	 */
	public void sendMessage(String message) {
		//for loop �� �̿��� list�� �ִ� ��� ServerWorker �� pw.println();
		for(int i=0; i<list.size(); i++) {
			list.get(i).pw.println(message);
		}
	}
	
	//nested class 
	public class ServerWorker implements Runnable{
		private Socket socket;	
		private String clientIp;
		private BufferedReader br;
		private PrintWriter pw;
		public ServerWorker(Socket socket) {
			super();
			this.socket = socket;
		}
		@Override
		public void run() {
			try {
				chatting();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(clientIp + " ��� �� ���� �߻� " + e.getMessage());
			} finally {
				if(socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					// list���� ���� ��ü�� �����Ѵ�
					list.remove(this);
					System.out.println(clientIp + "���� �����̽��ϴ�");
					sendMessage(clientIp + "���� �����̽��ϴ�");
				}
			}
		}
		
		public void chatting() throws IOException {
			clientIp = socket.getInetAddress().toString();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true); // true: autoflush
			System.out.println(clientIp + "���� �����ϼ̽��ϴ�");
			sendMessage(clientIp + "���� �����ϼ̽��ϴ�"); // ������ ��� ����ڿ��� �޼����� �����Ѵ�
			
			while(true) {
				String message = br.readLine(); // ģ���� �޼����� �Է¹޴´�
				if(message == null || message.trim().equalsIgnoreCase("exit")) {
					break;
				}
				// ������ ��� ����ڿ��� �޼����� ����Ѵ�
				sendMessage(clientIp + "��:" + message);
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