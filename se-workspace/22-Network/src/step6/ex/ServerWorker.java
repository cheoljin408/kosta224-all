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
		BufferedReader br = null; // Ŭ���̾�Ʈ�� �޼����� �Է�
		PrintWriter out = null; // Ŭ���̾�Ʈ���� �޼����� ���
		
		try {
			String clientIp = socket.getInetAddress().toString();
			System.out.println(clientIp + "���� �����ϼ̽��ϴ� ");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			while(true) {
				String message = br.readLine(); // Ŭ���̾�Ʈ�� ���� �޼����� �Է¹޴´�
				if(message == null || message.equals("exit")) {
					System.out.println(clientIp + "���� �����̽��ϴ�");
					break;
				}
				System.out.println(clientIp + "���� �޼���:" + message);
				out.println(message + "*server*"); // Ŭ���̾�Ʈ�� �޼����� ����Ѵ�
			}
		} finally {
			if(out != null)
				out.close();
			if(br != null)
				br.close();
		}
	}
}
