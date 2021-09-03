package step01;

// 단일 스레드 환경(main thread)
// TestThread1 program을 실행시켜 실행중이면 Process 하나 실행중이고 
// 이 Process 내의 실행 단위인 Thread(일꾼)가 하나 실행된다

// 아래 프로그램을 실행한 후 main thread 종료 출력 시점을 TestThread2와 비교해본다
class SingleTreadTest {
	public void test() {
		for(int i=0; i<10; i++) {
			System.out.println("main thread:" + i);
		}
	}
}

public class TestThread1 {
	public static void main(String[] args) {
		SingleTreadTest t = new SingleTreadTest();
		t.test();
		System.out.println("**main thread 종료**");
	}
}
