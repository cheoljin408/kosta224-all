package step13;

// 아래 클래스의 예는 멀티스레딩시 공유자원을 사용할 때 발생할 수 있는 문제를 확인
public class Toilet implements Runnable {
	// private boolean seat; // 인스턴스변수 기본 초기화 false

	@Override
	public void run() {
		try {
			use(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// synchronized: 특정 영역을 단일 스레드 환경으로 만든다
	// 1. method 단위에서 동기화 처리
	/*
	public synchronized void use(String guestName) throws InterruptedException {
		System.out.println(guestName + "님 입장");
		Thread.sleep(2000);
		System.out.println(guestName + "님 퇴장");
	}
	*/
	
	// 2. 특정 코드 블럭에서만 동기화 처리
	public void use(String guestName) throws InterruptedException {
		// 작업 1
		synchronized (this) {
			System.out.println(guestName + "님 입장");
			Thread.sleep(2000);
			System.out.println(guestName + "님 퇴장");	
		}
		
		// 작업 2
	}
}
