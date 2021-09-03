package step05;

public class InputWorker implements Runnable {

	@Override
	public void run() {
		try {
			input();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void input() throws InterruptedException {
		for(int i=0; i<10; i++) {
			System.out.println("서버로부터 메세지를 입력받는 스레스:" + i);
			Thread.sleep(1000);
		}
	}
}
