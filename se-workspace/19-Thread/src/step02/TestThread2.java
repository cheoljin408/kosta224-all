package step02;

/*
 	멀티 스레드 환경에서 실행해서 TestThread1(단일스레드 환경)과 실행 결과를 비교해본다
 	main thread + Worker thread
 	main thread에서 Worker Thread 객체 생성 후 start() 시키고
 	JVM은 스케줄링해서 Worker Thread의 run()를 호출해서 실행하게 한다
 */

// java.lang.Thread class를 상속받는 방식으로 스레드를 생성한다
class Worker extends Thread {
	// Thread class의 run 메소드를 오버라이딩: JVM이 호출한다
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("**Worder Thread 일하다**" + i);
		}
	}
}

public class TestThread2 {
	public static void main(String[] args) {
		Worker thread = new Worker();
		thread.start(); // 스레드를 실행 가능상태로 보낸다. 이후 JVM이 스케줄링해서 실행하게 한다
		System.out.println("**main thread 종료**");
	}
}
