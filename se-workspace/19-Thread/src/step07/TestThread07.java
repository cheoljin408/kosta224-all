package step07;

// Demon Thread Test ����
// ��� �����带 demon thread�� ó���ؼ� �� Work �����尡 ����Ǹ� �Բ� ����ȴ�
// backThread.setDemon(true);
public class TestThread07 {
	public static void main(String[] args) {
		Thread t = new Thread(new Word());
		t.start();
	}
}
