package org.kosta.webstudy28.model;

public class EmployeeVO {
	private int empno;
	private String ename;
	private int sal;
	private int deptno;
	private DepartmentVO departmentVO;
	
	public EmployeeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeVO(int empno, String ename, int sal, int deptno, DepartmentVO departmentVO) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;
		this.departmentVO = departmentVO;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
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

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public DepartmentVO getDepartmentVO() {
		return departmentVO;
	}

	public void setDepartmentVO(DepartmentVO departmentVO) {
		this.departmentVO = departmentVO;
	}
	
	
}
