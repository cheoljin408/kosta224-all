package step08;

public class MoveFileWorker implements Runnable {
	private int moveCount;
	private int movePeriod;
	
	public MoveFileWorker(int moveCount, int movePeriod) {
		super();
		this.moveCount = moveCount;
		this.movePeriod = movePeriod;
	}

	@Override
	public void run() {
		try {
			moveFile();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// moveCount 횟수만큼 반복하되 movePeriod 간격으로 실행하게 한다
	public void moveFile() throws InterruptedException {
		for(int i=0; i<moveCount; i++) {
			Thread.sleep(movePeriod);
			System.out.println("파일 이동 스레드 실행");
		}
	}
}
