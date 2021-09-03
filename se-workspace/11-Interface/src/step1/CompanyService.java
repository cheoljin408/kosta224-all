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

	/**
	 * 매개변수의 인자값을 전달된 사원번호 empNo와 배열 내의 요소의 사원번호가 일치하면
	 * 배열의 위치를 반환하는 메소드, 만약 일치하는 요소가 없으면 -1을 반환
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
	 * 사원 정보를 삭제하는 메소드
	 * 매개변수로 전달된 인자값 empNo에 해당하는 사원 객체가 배열요소로 존재하면 삭제하는 메소드
	 * 만약 사원번호에 일치하는 배열 요소가 없다면 ex) 99 사원번호에 해당하는 사원이 없어서 삭제불가라는 메세지를 남긴다
	 * 
	 * 일치하는 사원이 있으면 해당 사원이 배열에 위치한 position을 이용해 그 시점부터 
	 * 사원수보다 작을 동안 반복하면서 뒤 요소를 앞 요소로 할당하는 방식으로 삭제한다
	 * (ex -> array[i] = array[i+1])
	 * 삭제한 후 총 사원수는 -1감소시킨다
	 * 만약 삭제할 요소가 배열의 마지막 요소라면 array[i] = array[i+1]; 작업이 불가능하므로 이 경우에는 직접 null을 할당한다
	 * (array.length를 이용하면 배열의 마지막 요소인지 확인 가능하다)
	 * 
	 * @param empNo
	 */
	public void deleteEmployeeByEmpNo(String empNo) {
		int position = findPositionByEmpNo(empNo);
		if(position == -1) {
			System.out.println(empNo + "사원번호에 해당하는 사원이 없어서 삭제불가");
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
	*/
	
}
