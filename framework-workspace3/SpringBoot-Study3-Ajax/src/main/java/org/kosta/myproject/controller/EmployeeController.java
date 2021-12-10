package org.kosta.myproject.controller;

import java.util.List;

import org.kosta.myproject.model.domain.EmployeeDTO;
import org.kosta.myproject.model.mapper.DepartmentMapper;
import org.kosta.myproject.model.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
	
	private DepartmentMapper departmentMapper;
	private EmployeeMapper employeeMapper;
	
	@Autowired
	public EmployeeController(DepartmentMapper departmentMapper, EmployeeMapper employeeMapper) {
		super();
		this.departmentMapper = departmentMapper;
		this.employeeMapper = employeeMapper;
	}
	
	@GetMapping("employeeAjaxTestView")
	public String employeeAjaxTestView(Model model) {
		model.addAttribute("deptList", departmentMapper.getDepartmentList());
		return "employee/list";
	}
	
	@RequestMapping("findEmployeeListByDeptNo")
	@ResponseBody
	public List<EmployeeDTO> findEmployeeListByDeptNo(int deptNo) {
		return employeeMapper.findEmployeeListByDeptNo(deptNo);
	}
	
	@RequestMapping("findEmplyeeListDynamicSQL")
	@ResponseBody
	public List<EmployeeDTO> findEmplyeeListDynamicSQL(EmployeeDTO employeeDTO) {
		System.out.println("controller: " + employeeDTO);
		return employeeMapper.findEmplyeeListDynamicSQL(employeeDTO);
	}

}
