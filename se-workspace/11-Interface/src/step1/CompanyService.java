package step1;

public class CompanyService {
	private Employee[] e;
	private int idx;

	public CompanyService(int len) {
		super();
		this.e = new Employee[len];
		this.idx = 0;
	}
	
	public void add(Employee e) {
		this.e[this.idx] = e;
		this.idx++;
	}

	public void printAll() {
		for(int i=0; i<this.idx; i++) {
			System.out.println(this.e[i]);
		}
	}

	/**
	 * �Ű������� ���޵� empNo�� �ش��ϴ� ��� ������ array���� �����ϸ�
	 * �ش� ��ü�� �ּҰ��� ��ȯ�ϰ�
	 * �������� ������ null�� ��ȯ
	 * @param empNo
	 * @return
	 */
	public Employee findEmployeeByEmpNo(String empNo) {
		for(int i=0; i<this.idx; i++) {
			if(this.e[i].getEmpNo().equals(empNo)) {
				return this.e[i];
			}
		}
		return null;
	}

	/**
	 * �Ű������� ���ڰ��� ���޵� �����ȣ empNo�� �迭 ���� ����� �����ȣ�� ��ġ�ϸ�
	 * �迭�� ��ġ�� ��ȯ�ϴ� �޼ҵ�, ���� ��ġ�ϴ� ��Ұ� ������ -1�� ��ȯ
	 * @param empNo
	 * @return
	 */
	public int findPositionByEmpNo(String empNo) {
		for(int i=0; i<this.idx; i++) {
			if(this.e[i].getEmpNo().equals(empNo)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * ��� ������ �����ϴ� �޼ҵ�
	 * �Ű������� ���޵� ���ڰ� empNo�� �ش��ϴ� ��� ��ü�� �迭��ҷ� �����ϸ� �����ϴ� �޼ҵ�
	 * ���� �����ȣ�� ��ġ�ϴ� �迭 ��Ұ� ���ٸ� ex) 99 �����ȣ�� �ش��ϴ� ����� ��� �����Ұ���� �޼����� �����
	 * 
	 * ��ġ�ϴ� ����� ������ �ش� ����� �迭�� ��ġ�� position�� �̿��� �� �������� 
	 * ��������� ���� ���� �ݺ��ϸ鼭 �� ��Ҹ� �� ��ҷ� �Ҵ��ϴ� ������� �����Ѵ�
	 * (ex -> array[i] = array[i+1])
	 * ������ �� �� ������� -1���ҽ�Ų��
	 * ���� ������ ��Ұ� �迭�� ������ ��Ҷ�� array[i] = array[i+1]; �۾��� �Ұ����ϹǷ� �� ��쿡�� ���� null�� �Ҵ��Ѵ�
	 * (array.length�� �̿��ϸ� �迭�� ������ ������� Ȯ�� �����ϴ�)
	 * 
	 * @param empNo
	 */
	public void deleteEmployeeByEmpNo(String empNo) {
		int position = findPositionByEmpNo(empNo);
		if(position == -1) {
			System.out.println(empNo + "�����ȣ�� �ش��ϴ� ����� ��� �����Ұ�");
		}
		else {
			for(int i=position; i<this.idx; i++) {
				if(i+1 == this.e.length) {
					this.e[i] = null;
				}
				else {
					this.e[i] = this.e[i+1];
				}
			}
			this.idx--;
		}
	}
	
	/*
	public void deleteEmployeeByEmpNo(String empNo) {
		for(int i=0; i<this.idx; i++) {
			if(this.e[i].getEmpNo().equals(empNo)) { // �Ű������� ���޵� empNo�� �迭 ����� empNo�� ��ġ�ϸ�
				for(int j=i; j<this.idx-1; j++) {
					this.e[j] = this.e[j+1];
				}
				this.idx--;
				return;
			}
		}
		System.out.println(empNo + " ��� ��ȣ�� �ش��ϴ� ����� ��� ���� �Ұ�");
	}
	*/
	
}
