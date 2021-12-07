package org.kosta.myproject;

import javax.annotation.Resource;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.maper.DepartmentMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStudy2ApplicationTests {
	
	@Resource
	private DepartmentMapper deptMapper;

	@Test
	void contextLoads() {
	}
	
	@Test
	void deptCount() {
		int totalDepartmentCount = deptMapper.getTotalDepartmentCount();
		System.out.println("부서수: " + totalDepartmentCount);
		Assertions.assertThat(totalDepartmentCount).isEqualTo(3);
	}

}
