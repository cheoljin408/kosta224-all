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
	 	ServerScoket 생성
	 	loop
	 	accept()
	 	ServerWorker 생성
	 	Thread 생성
	 	start()
	 */
	// client와 통신을 하는 객체(ServerWorker > socket)의 리스트를 관리
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
	 	각각의 ServerWorker가 클라이언트로부터 입력받은 메세지를
	 	접속한 전체 클라이언트에게 출력하기 위한 메소드
	 	아래 메소드를 개별 ServerWorker의 run 메소드에서 호출해서 사용한다
	 */
	public void sendMessage(String message) {
		// for loop을 이용해 list에 있는 모든 ServerWorker의 pw.println();
		for(int i=0; i<list.size(); i++) {
			list.get(i).pw.println(list.get(i).clientIp + "님:" + message);
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
			
			System.out.println(clientIp + "님 입장하셨습니다!");
			sendMessage(clientIp + "님 입장하셨습니다!");
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
			br = null; // client message 를 입력
			pw = null; // client message를 출력
			
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream(), true);
				while(true) {
					String message = br.readLine();
					if(message == null || message.equalsIgnoreCase("exit")) {
						break; // while문을 종료
					}
					System.out.println(clientIp + ":" + message);
					sendMessage(message);
				}
			} finally {
				list.remove(this);
				System.out.println(clientIp + "님이 퇴장하셨습니다");
				sendMessage(clientIp + "님이 퇴장하셨습니다");
				
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
