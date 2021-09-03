package step05;

/*
 	멀티스레드 예제
 	채팅 클라이언트 프로세스 (main thread + 서버로부터 입력받는 thread + 서버에 출력하는 thread)
 */

public class TestThread5 {
	public static void main(String[] args) {
		System.out.println("**main thread 시작**");
		
		InputWorker worker1 = new InputWorker();
		OutputWorker worker2 = new OutputWorker();
		
		Thread t1 = new Thread(worker1);
		Thread t2 = new Thread(worker2);
		
		t1.start();
		t2.start();
		
		System.out.println("**main thread 종료**");
	}
}
