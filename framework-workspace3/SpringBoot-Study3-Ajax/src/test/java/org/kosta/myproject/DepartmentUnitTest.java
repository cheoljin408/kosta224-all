package org.kosta.myproject;

import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.domain.DepartmentDTO;
import org.kosta.myproject.model.mapper.DepartmentMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DepartmentUnitTest {
	
	@Resource
	DepartmentMapper mapper;


	@Test
	void contextLoads() {
		System.out.println(mapper);
	}
	
	@Test
	void getDepartmentList() {
		List<DepartmentDTO> list = mapper.getDepartmentList();
		for(DepartmentDTO dto:list) {
			System.out.println(dto);
		}
	}

}
