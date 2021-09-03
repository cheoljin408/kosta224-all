package step06;

/*
 	하나의 클래스에서 다수의 스레드를 생성해서 실행해보는 예제
 	채팅 서버를 가정, 서비스 내용(채팅)은 동일하나
 	접속한 다수의 클라이언트엑 동시에 서비스하기 위해
 	다수의 스레드를 생성해 실행하게 하는 스레드 프로그램을 간단히 구현해본다
 	-> 이후 Network 공부하고 난 후에는 직접 구현해볼 예정
 */

public class TestThread6 {
	public static void main(String[] args) {
		System.out.println("**main thraed 시작**");
		
		ServerWorker worker = new ServerWorker();
		Thread t1 = new Thread(worker, "A 고객담당");
		t1.start();
		Thread t2 = new Thread(worker, "B 고객담당");
		t2.start();
		Thread t3 = new Thread(worker, "C 고객담당");
		t3.start();
		
		System.out.println("**main thraed 종료**");
	}
}
