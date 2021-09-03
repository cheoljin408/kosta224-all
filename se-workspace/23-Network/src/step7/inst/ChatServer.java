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
	 *  ServerSocket 생성  
	 *  loop  
	 *  accept() 
	 *  ServerWorker 생성 
	 *  list.add(ServerWorker) 
	 *  Thread 생성 
	 *  start() 
	 */
	// client와 통신을 하는 객체(ServerWorker>socket)의 리스트를 관리  
	// 다수의 ServerWorker Thread에 의해 공유되어 사용되는 리스트이므로 thread-safe 하게 처리해본다(동기화 처리)
	// private ArrayList<ServerWorker> list=new ArrayList<ServerWorker>();
	private List<ServerWorker> list = Collections.synchronizedList(new ArrayList<ServerWorker>());
	
	public void go() throws IOException {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(5432);
			System.out.println("**ChatServer 실행**");
			
			while(true) {
				Socket socket = serverSocket.accept();
				ServerWorker serverWorker = new ServerWorker(socket);
				
				// list에 추가
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
	 *  각각의 ServerWorker가 클라이언트로부터 입력받은 메세지를 
	 *  접속한 전체 클라이언트에게 출력하기 위한 메서드 
	 *  아래 메서드를 개별 ServerWorker의 run 메서드에서 호출해서 사용한다 
	 */
	public void sendMessage(String message) {
		//for loop 를 이용해 list에 있는 모든 ServerWorker 의 pw.println();
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
				System.out.println(clientIp + " 통신 중 오류 발생 " + e.getMessage());
			} finally {
				if(socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					// list에서 현재 객체를 삭제한다
					list.remove(this);
					System.out.println(clientIp + "님이 나가셨습니다");
					sendMessage(clientIp + "님이 나가셨습니다");
				}
			}
		}
		
		public void chatting() throws IOException {
			clientIp = socket.getInetAddress().toString();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true); // true: autoflush
			System.out.println(clientIp + "님이 입장하셨습니다");
			sendMessage(clientIp + "님이 입장하셨습니다"); // 접속한 모든 사용자에게 메세지를 전송한다
			
			while(true) {
				String message = br.readLine(); // 친구의 메세지를 입력받는다
				if(message == null || message.trim().equalsIgnoreCase("exit")) {
					break;
				}
				// 접속한 모든 사용자에게 메세지를 출력한다
				sendMessage(clientIp + "님:" + message);
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