package step11;

// 다수의 스레드가 공유 자원(객체)을 이용할 수 있는 것을 확인하는 예제
public class TestThread11 {
	public static void main(String[] args) {
		ServiceWorker sw = new ServiceWorker();
		
		Thread t1 = new Thread(sw, "1번 스레드");
		Thread t2 = new Thread(sw, "2번 스레드");
		Thread t3 = new Thread(sw, "3번 스레드");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
