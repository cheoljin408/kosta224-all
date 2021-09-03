package step08;

public class TestThreadReview8 {
	public static void main(String[] args) {
		// Thread Review
		int makeCount = 10; // ����Ƚ��
		int makePeriod = 1000; // 1�� �������� ����
		// 1. makeFile �޼ҵ� ����
		// 2. makeWorker�� �̿��� ������ ���� �� start��Ų��
		MakeFileWorker makeWorker = new MakeFileWorker(makeCount, makePeriod);
		Thread makeThread = new Thread(makeWorker);
		makeThread.start();
		
		// ����2
		int moveCount = 3;
		int movePeriod = 4000; // 4�ʰ���
		// 1. moveFile() ����
		// 2. moveWorker�� �̿��� ������ ���� �� start()
		MoveFileWorker moveFileWorker = new MoveFileWorker(moveCount, movePeriod);
		Thread moveThread = new Thread(moveFileWorker);
		moveThread.start();
	}
}
