package org.kosta.myproject.model.domain;

public class EmployeeDTO {
	private int empNo;
	private String ename;
	private int sal;
	// has a
	private DepartmentDTO departmentDTO;
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDTO(int empNo, String ename, int sal, DepartmentDTO departmentDTO) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.sal = sal;
		this.departmentDTO = departmentDTO;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}
	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empNo=" + empNo + ", ename=" + ename + ", sal=" + sal + ", departmentDTO=" + departmentDTO
				+ "]";
	}
	
	
}
