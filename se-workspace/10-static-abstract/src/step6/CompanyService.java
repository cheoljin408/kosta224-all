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
	 * 매개변수로 전달된 empNo에 해당하는 사원 정보가 array내에 존재하면
	 * 해당 객체의 주소값을 반환하고
	 * 존재하지 않으면 null을 반환
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
			if(this.e[i].getEmpNo().equals(empNo)) { // 매개변수로 전달된 empNo와 배열 요소의 empNo가 일치하면
				for(int j=i; j<this.idx-1; j++) {
					this.e[j] = this.e[j+1];
				}
				this.idx--;
				return;
			}
		}
		System.out.println(empNo + " 사원 번호에 해당하는 사원이 없어서 삭제 불가");
	}
	
}
