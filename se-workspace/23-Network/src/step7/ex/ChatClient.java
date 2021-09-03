package step7.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import common.IP;

public class ChatClient {
	private Socket socket;
	private BufferedReader br; // 친구들의 메세지를 입력
	private Scanner scanner; // 콘솔에서 입력
	private PrintWriter pw; // 콘솔에서 입력받은 자신의 메세지를 서버로 출력
	/*
	 	Socket 생성
	 	ReceiverWorker 생성, Thread 생성, setDaement(true), start()
	 	콘솔로부터 입력받은 (Scanner) 메세지를 서버로 출력하는 기능을 구현
	 	(exit 를 입력하면 종료)
	 */
	
	public void go() throws UnknownHostException, IOException {
		try {
			socket = new Socket(IP.LOCAL, 5432);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			scanner = new Scanner(System.in);
			pw = new PrintWriter(socket.getOutputStream(), true); // auto flush: buffer에 있는 데이터를 즉시 출력
			
			// 서버에서 메세지를 입력받을 스레드를 생성하고 start 시킨다
			ReceiverWorker worker = new ReceiverWorker();
			Thread receiverThread = new Thread(worker); // 친구들의 메세지를 입력받은 스레드를 생성
			receiverThread.setDaemon(true); // 자신을 실행시킨 thread가 종료되면 함께 종료 되도록 설정
			receiverThread.start();
			
			// 자신의 메세지를 서버로 출력하는 작업 정의
			System.out.println("**ChatClient 실행**");
			while(true) {
				String message = scanner.nextLine(); // 콘솔 상에서 대기하다가 사용자가 메세지 입력 후 엔터 누르면 동작
				pw.println(message);
				if(message.trim().equalsIgnoreCase("exit")) {
					break;
				}
			}
		} finally {
			if(scanner != null)
				scanner.close();
			if(socket != null)
				socket.close();
			System.out.println("**ChatClient 종료**");
		}
	}
	
	// nested class
	public class ReceiverWorker implements Runnable {

		// 서버에서 친구들의 메세지를 입력받아 콘솔에 출력한다
		@Override
		public void run() {
			try {
				receiveMessage();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void receiveMessage() throws IOException {
			while(true) {
				String message = br.readLine();
				if(message == null)
					break;
				System.out.println(message);
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			new ChatClient().go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
