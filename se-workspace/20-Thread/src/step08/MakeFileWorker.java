package step08;

public class MakeFileWorker implements Runnable {
	private int makeCount;
	private int makePeiod;
	
	public MakeFileWorker(int makeCount, int makePeiod) {
		super();
		this.makeCount = makeCount;
		this.makePeiod = makePeiod;
	}

	// run(): JVM�� �����ٸ��ؼ� ȣ���ϴ� �޼ҵ�
	// ���� �������� ���� ������ �����ϴ� �޼ҵ�
	@Override
	public void run() {
		try {
			makeFile();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void makeFile() throws InterruptedException {
		for(int i=0; i<makeCount; i++) {
			System.out.println("���� ���� ������ ����");
			Thread.sleep(makePeiod);
		}
	}

}
