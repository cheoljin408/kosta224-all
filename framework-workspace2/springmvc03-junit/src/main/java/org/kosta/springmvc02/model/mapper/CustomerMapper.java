package org.kosta.springmvc02.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.springmvc02.model.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {

	int getTotalCustomerCount();

	CustomerDTO findCustomerById(String id);

	void registerCustomer(CustomerDTO customerDTO);

}
