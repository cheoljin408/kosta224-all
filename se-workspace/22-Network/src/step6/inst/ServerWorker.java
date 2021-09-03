package step6.inst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker implements Runnable {
	private Socket socket;
	private String clientIp;
	
	public ServerWorker(Socket socket) {
		super();
		this.socket = socket;
		clientIp = socket.getInetAddress().toString();
	}
	
	@Override
	public void run() {
		System.out.println(clientIp + "님 입장하셨습니다");
		try {
			echo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(clientIp + "님이 나가셨습니다");
	}
	
	public void echo() throws IOException {
		BufferedReader br = null; // client message 를 입력
		PrintWriter pw = null; // client message를 출력
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			while(true) {
				String message = br.readLine();
				if(message == null || message.equals("exit")) {
					break; // while문을 종료
				}
				System.out.println(clientIp + ":" + message);
				pw.println(message + "*server*");
			}
		} finally {
			if(br != null)
				br.close();
			if(pw != null)
				pw.close();
			if(socket != null)
				socket.close();
		}
	}

}
