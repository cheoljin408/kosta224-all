package step04;

public class AudioWorker implements Runnable {
	// JVM에 의해 호출, 스레드 서비스를 정의하는 메소드
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("음향서비스 스레드 실행:" + i);
			try {
				Thread.sleep(200); // 0.2초간 중단 후 재개
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
