package step07;

// Demon Thread Test 예제
// 백업 스레드를 demon thread로 처리해서 현 Work 스레드가 종료되면 함께 종료된다
// backThread.setDemon(true);
public class TestThread07 {
	public static void main(String[] args) {
		Thread t = new Thread(new Word());
		t.start();
	}
}
