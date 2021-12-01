package org.kosta.springmvc.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.springmvc02.model.dto.CustomerDTO;
import org.kosta.springmvc02.model.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class UnitTestCustomer {
	
	@Autowired
	private CustomerMapper mapper;
	
	@Test
	public void mapperTest() {
		System.out.println(mapper);
	}
	
	@Test
	public void customerCount() {
		// System.out.println(mapper.getTotalCustomerCount());
		// import org.junit.Assert;
		Assert.assertEquals(3, mapper.getTotalCustomerCount()); // 1. 기대값 2. 실제값
	}
	
	@Test
	public void findCustomerById() {
		// System.out.println(mapper.findCustomerById("java"));
		Assert.assertNotNull(mapper.findCustomerById("java2"));
	}
	
	@Test
	public void registerCustomer() {
		mapper.registerCustomer(new CustomerDTO("springmvc", "이강인", "마요르카"));
		System.out.println(mapper.findCustomerById("springmvc"));
	}
}
