package step6;

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
	
}
