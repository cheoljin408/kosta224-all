package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.domain.EmployeeDTO;

@Mapper
public interface EmployeeMapper {
	
	List<EmployeeDTO> findEmployeeListByDeptNo(int deptNo);

	List<EmployeeDTO> findEmplyeeListDynamicSQL(EmployeeDTO employeeDTO);
}
