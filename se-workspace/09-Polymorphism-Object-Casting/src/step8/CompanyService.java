package step8;

import step5.Employee;

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

	public Employee findEmployeeByEmpNo(String empNo) {
		for(int i=0; i<this.idx; i++) {
			if(this.e[i].getEmpNo().equals(empNo)) {
				return this.e[i];
			}
		}
		return null;
	}
	
}
