package org.kosta.myproject.model.maper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {

	int getTotalDepartmentCount();

}
