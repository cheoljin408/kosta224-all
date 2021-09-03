package step5;

import java.util.ArrayList;

// TestList2�� Grnrgic�� �������� �ʾ��� ���� ��, Generic�� ������ TestList
public class TetsList2 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new FriendDTO("������", 100));
		list.add(new FriendDTO("�ں���", 200));
		list.add(new FriendDTO("���ϴ�", 50));
		list.add("������"); // Generic�� �������� �ʾƼ� �ٸ� Ÿ���� ��ҵ� �߰� ����
		// list ����� index�� 1�� ����� name�� ����ϰ��� �Ѵ�
		/*
		Object o = list.get(1);
		FriendDTO dto = (FriendDTO)o; // ����ȯ, Object down casting�� �ʿ�
		System.out.println(dto.getName());
		*/
		
		// �Ʒ��� ���� �ٿ��� ����
		FriendDTO dto = (FriendDTO)list.get(1);
		System.out.println(dto.getName());
		
		// for���� �̿��� ����� getMoney() ȣ���ؼ� money�� ���
		for(int i=0; i<list.size(); i++) {
			FriendDTO fd = (FriendDTO)list.get(i);
			System.out.println(fd.getMoney());
		}
	}
}
