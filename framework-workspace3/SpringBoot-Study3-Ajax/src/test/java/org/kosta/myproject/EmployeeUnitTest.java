package org.kosta.myproject;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.domain.DepartmentDTO;
import org.kosta.myproject.model.domain.EmployeeDTO;
import org.kosta.myproject.model.mapper.EmployeeMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeUnitTest {
	
	@Resource
	EmployeeMapper mapper;
	
	@Test
	void findEmployeeListByDeptNo() {
		System.out.println(mapper.findEmployeeListByDeptNo(10));
	}
	
	@Test
	void findEmployeeListDynamicSQL() {
		/*
		 	MyBatis Dynamic SQL 활용
		 	1. 부서번호와 사원명이 없을 때는 전체 조회
		 	2. 부서번호만 있으면 부서번호로 조회
		 	3. 사원명만 있으면 사원명으로 조회
		 	4. 부서번호와 사원명이 있으면 두 조건으로 조회
		 */
		// case 1 test
		/*
		EmployeeDTO employeeDTO = new EmployeeDTO();
		List<EmployeeDTO> list = mapper.findEmplyeeListDynamicSQL(employeeDTO);
		for(EmployeeDTO dto:list) {
			System.out.println(dto);
		}
		*/
		
		// case 2 test
		/*
		EmployeeDTO employeeDTO = new EmployeeDTO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDeptNo(20);
		employeeDTO.setDepartmentDTO(departmentDTO);
		
		List<EmployeeDTO> list = mapper.findEmplyeeListDynamicSQL(employeeDTO);
		for(EmployeeDTO dto:list) {
			System.out.println(dto);
		}
		*/
		
		// case 3 test
		/*
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEname("유");
		List<EmployeeDTO> list = mapper.findEmplyeeListDynamicSQL(employeeDTO);
		for(EmployeeDTO dto:list) {
			System.out.println(dto);
		}
		*/
		
		// case 4 test
		EmployeeDTO employeeDTO = new EmployeeDTO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDeptNo(10);
		employeeDTO.setDepartmentDTO(departmentDTO);
		employeeDTO.setEname("유");
		
		List<EmployeeDTO> list = mapper.findEmplyeeListDynamicSQL(employeeDTO);
		for(EmployeeDTO dto:list) {
			System.out.println(dto);
		}
	}

}
