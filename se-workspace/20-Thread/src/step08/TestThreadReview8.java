package step08;

public class TestThreadReview8 {
	public static void main(String[] args) {
		// Thread Review
		int makeCount = 10; // 실행횟수
		int makePeriod = 1000; // 1초 간격으로 실행
		// 1. makeFile 메소드 구현
		// 2. makeWorker를 이용해 스레드 생성 후 start시킨다
		MakeFileWorker makeWorker = new MakeFileWorker(makeCount, makePeriod);
		Thread makeThread = new Thread(makeWorker);
		makeThread.start();
		
		// 연습2
		int moveCount = 3;
		int movePeriod = 4000; // 4초간격
		// 1. moveFile() 구현
		// 2. moveWorker를 이용한 스레드 생성 및 start()
		MoveFileWorker moveFileWorker = new MoveFileWorker(moveCount, movePeriod);
		Thread moveThread = new Thread(moveFileWorker);
		moveThread.start();
	}
}
