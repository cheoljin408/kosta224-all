package step04;

/*
 	멀티스레딩 테스트 예제
 	TestThread04 프로세스(main thread + 영상 thread + 음향 thread)
 */

public class TestThread4 {
	public static void main(String[] args) {
		System.out.println("**main thread 시작**");
		
		VideoWorker worker1 = new VideoWorker();
		AudioWorker worker2 = new AudioWorker();
		
		Thread t1 = new Thread(worker1);
		Thread t2 = new Thread(worker2);
		
		t1.start(); // t1 스레드를 실행가능 상태로 보낸다
		t2.start();
		
		System.out.println("**main thread 종료**");
	}
}
