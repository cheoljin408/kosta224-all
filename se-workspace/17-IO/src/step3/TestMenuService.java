package step3;

import java.io.IOException;

public class TestMenuService {
	public static void main(String[] args) {
		String path = "C:\\kosta224\\iotest2\\lunch\\menu.txt";
		MenuService service = new MenuService(path);
		
		// try
		try {
			service.order();
		} catch(IOException e) {
			e.printStackTrace();
		}
		//catch
	}
}

/*
	���� �޴��� �ֹ��ϼ���: ���
	��� �ֹ�
	���� �޴��� �ֹ��ϼ���: ���
	��� �ֹ�
	���� �޴��� �ֹ��ϼ���: �ֹ���
	�ֹ��� �Ϸ�Ǿ����ϴ�
	
	menu.txt ����
	���
	���
*/