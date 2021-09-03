package step3;

/*
 	throws, throw, try, catch, finally �� �׽����ϴ� ����
 	�ʿ�� Ư�� Exception�� ���� �����ؼ� ����� �� �ִ�
 	Ư�� Exception�� ������ ���� java.lang.Exception�� ��ӹ����� �ȴ�(extends Exception)
 */
class AgeException extends Exception {
	// IO �κ� ��ü ����ȭ���� ������ ����
	private static final long serialVersionUID = -1641932421720612222L;
	AgeException(String message) {
		super(message); // �θ��� Exception�� �����ڸ� ȣ���� �� ���� �޼����� ���� -> ���� catch �������� e.getMessage()�� �̿��� ��ȯ���� �� �ִ�
	}
}

class MovieService {
	// 19�� �̻��̸� ��ȭ ���� �����ϰ� �̸��̸� AgeException�� �߻���Ű�� throws �Ѵ�
	public void enter(int age) throws AgeException {
//		try {
			if(age < 19) {
				throw new AgeException(age + "�� �̼������̹Ƿ� ��ȭ������ �Ұ��մϴ�"); // Exception �߻�
			}
			System.out.println("��ſ� ��ȭ ���� �Ǽ���!");	
//		} finally {
//			System.out.println("finally�� �׻� �����ϴ� ����, ������ �� ����~");
//		}
	}
}

public class TestThrows2 {
	public static void main(String[] args) {
		MovieService service = new MovieService();
		try {
			service.enter(17);
		} catch (AgeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("�ý��� ���� ����");
	}
}
