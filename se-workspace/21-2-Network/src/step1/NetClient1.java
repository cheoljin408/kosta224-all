package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import common.IP;

public class NetClient1 {
	public void go() throws UnknownHostException, IOException {
		Socket socket = new Socket(IP.LOCAL, 5432);
		System.out.println("**NetClient가 서버에 접속함**");
		// InputStreaReader: 8bit 스트림(바이트스트림)을 16bit 스트림(문자스트림)으로 변환
		InputStreamReader ir = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		String message = br.readLine();
		System.out.println("서버가 보낸 메세지:" + message);
		br.close();
		socket.close();
		
		System.out.println("**NetClient 종료**");
	}
	
	public static void main(String[] args) {
		NetClient1 client = new NetClient1();
		try {
			client.go();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
