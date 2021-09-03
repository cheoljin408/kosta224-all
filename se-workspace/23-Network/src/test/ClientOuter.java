package test;

public class ClientOuter {
	private String socket;
	
	public void run() {
		System.out.println(socket);
	}
	
	// 수신을 전담하는 스레드 클래스를 Nested class로 정의
	public class Reworker {
		public void run() {
			System.out.println(socket);
		}
	}
}
