package step04;

public class VideoWorker implements Runnable {
	// run(): JVM�� ���ؼ� ȣ��Ǵ� ���� ������ ���񽺰� ���ǵǾ� �ִ� �޼ҵ�
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("���󼭺� ������ ����:" + i);
			try {
				Thread.sleep(200); // 0.2�ʰ� �ߴ� �� �簳
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
