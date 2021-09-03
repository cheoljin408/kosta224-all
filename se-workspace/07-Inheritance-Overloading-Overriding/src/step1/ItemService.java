package step1;
// Service: ����Ͻ� ������ ������ Ŭ����(Object)
public class ItemService {
	// �Ű������� ���޵� ���ڰ��� items �迭�̹Ƿ� ������ Ÿ���� ItemVO[] �̾�� �Ѵ�.
	// items �迭 ��� �������� name�� ��� ����Ѵ�.
	public void printAll(ItemVO [] items) {
		for(int i=0; i<items.length; i++) {
			System.out.println(items[i].getName());
		}
	}

	public void printNameAndPriceByPrice(ItemVO items[], int price) {
		for(int i=0; i<items.length; i++) {
			if(price > items[i].getPrice()) {
				System.out.println(items[i].getName() + " " + items[i].getPrice());
			}
		}
	}
	
}
