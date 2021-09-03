package step12;

// 아래 클래스의 예는 멀티스레딩시 공유자원을 사용할 때 발생할 수 있는 문제를 확인
public class Toilet implements Runnable {
	private boolean seat; // 인스턴스변수 기본 초기화 false

	@Override
	public void run() {
		try {
			use(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void use(String guestName) throws InterruptedException {
		if(seat == false) {
			Thread.sleep(1000);
			seat = true;
			System.out.println(guestName + "님 입장");
			Thread.sleep(2000);
			System.out.println(guestName + "님 퇴장");
			seat = false;
		}
		else {
			System.out.println(guestName + "님 현재 화장실을 다른 분이 사용중이셔서 이따가 오세요");
		}
	}
}
