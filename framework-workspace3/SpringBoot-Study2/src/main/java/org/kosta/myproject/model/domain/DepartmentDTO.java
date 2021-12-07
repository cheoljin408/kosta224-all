package org.kosta.myproject.model.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentDTO {
	private int deptNo;
	private String dname;
	private String loc;
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentDTO(int deptNo, String dname, String loc) {
		super();
		this.deptNo = deptNo;
		this.dname = dname;
		this.loc = loc;
	}
	
	
}
