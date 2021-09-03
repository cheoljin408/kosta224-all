package step6.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker implements Runnable {
	private Socket socket;
	
	public ServerWorker(Socket socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			runServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void runServer() throws IOException {
		BufferedReader br = null; // 클라이언트의 메세지를 입력
		PrintWriter out = null; // 클라이언트에세 메세지를 출력
		
		try {
			String clientIp = socket.getInetAddress().toString();
			System.out.println(clientIp + "님이 입장하셨습니다 ");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				String message = br.readLine(); // 클라이언트가 보낸 메세지를 입력받는다
				if(message == null || message.equals("exit")) {
					System.out.println(clientIp + "님이 나가셨습니다");
					break;
				}
				System.out.println(clientIp + "님의 메세지:" + message);
				out.println(message + "*server*"); // 클라이언트로 메세지를 출력한다
			}
		} finally {
			if(out != null)
				out.close();
			if(br != null)
				br.close();
		}
	}
}
