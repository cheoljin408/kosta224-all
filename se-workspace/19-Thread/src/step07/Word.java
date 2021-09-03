package step07;

// 문서작업 스레드가 실행되는 시점에
// 백업 작업 스레드를 함께 실행시킨다
public class Word implements Runnable {

	@Override
	public void run() {
		try {
			// 백업 스레드를 생성해서 start시킨다
			BackupWorker w = new BackupWorker();
			Thread backThread = new Thread(w);
			// 백업 스레드를 demon thread로 처리해서 현 Word 스레드가 종료되면 함께 종료되도록 한다
			backThread.setDaemon(true);
			backThread.start();
			execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void execute() throws InterruptedException {
		for(int i=0; i<10; i++) {
			System.out.println("워드문서작업 " + i);
			Thread.sleep(1000);
		}
	}
	
}
