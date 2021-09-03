package step3;

import java.util.Random;
import java.util.TreeSet;

public class LottoService {
	/**
	 * �ζ� 1~45������ ����(�ߺ��Ǿ�� �ȵȴ�) 6���� ���;� �Ѵ�
	 * 
	 * ������ �� �߻���Ű�� ���� Random�� �̿�
	 * 
	 * �ߺ� ����x, ���� ���� TreeSet �̿�
	 * 
	 * while loop�� ����(������ Random �� nextInt()�� ������ ������ ������� �ֱ� ������)
	 * -> TreeSet�� size()�� 6�� �� ������ �ݺ��ؾ� ��
	 * @return
	 */
	public TreeSet<Integer> createLottoNumber() {
		 // �� Ǯ��
		/*
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random r = new Random();
		
		while(lotto.size() < 6) {
			lotto.add(r.nextInt(45) + 1);
		}
		return lotto;
		*/
		
		// ����� Ǯ��
		TreeSet<Integer> set = new TreeSet<Integer>();
		Random r = new Random();
		while(set.size() < 6) {
			// nextInt(45)�� 0~44���� ������ ���� �����Ƿ� +1�� �Ѵ�
			set.add(r.nextInt(45) + 1);
		}
		
		return set;
	}
}
