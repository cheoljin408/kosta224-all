package step04;

public class VideoWorker implements Runnable {
	// run(): JVM에 의해서 호출되는 실제 스레드 서비스가 정의되어 있는 메소드
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("영상서비스 스레드 실행:" + i);
			try {
				Thread.sleep(200); // 0.2초간 중단 후 재개
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
