package step04;

/*
 	��Ƽ������ �׽�Ʈ ����
 	TestThread04 ���μ���(main thread + ���� thread + ���� thread)
 */

public class TestThread4 {
	public static void main(String[] args) {
		System.out.println("**main thread ����**");
		
		VideoWorker worker1 = new VideoWorker();
		AudioWorker worker2 = new AudioWorker();
		
		Thread t1 = new Thread(worker1);
		Thread t2 = new Thread(worker2);
		
		t1.start(); // t1 �����带 ���డ�� ���·� ������
		t2.start();
		
		System.out.println("**main thread ����**");
	}
}
