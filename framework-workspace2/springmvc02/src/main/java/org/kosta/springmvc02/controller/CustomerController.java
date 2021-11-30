package org.kosta.springmvc02.controller;

import org.kosta.springmvc02.model.dto.CustomerDTO;
import org.kosta.springmvc02.model.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	private CustomerMapper customerMapper;
	
	@Autowired
	public CustomerController(CustomerMapper mapper) {
		super();
		this.customerMapper = mapper;
	}
	
	@RequestMapping("getTotalCustomerCount.do")
	public String getTotalCustomerCount(Model model) {
		model.addAttribute("totalCount", customerMapper.getTotalCustomerCount());
		return "customer-count";
	}
	
	@RequestMapping("findCustomerById.do")
	public String findCustomerById(String id, Model model) {
		CustomerDTO customerDTO = customerMapper.findCustomerById(id);
		model.addAttribute("customerDTO", customerDTO);
		
		if(customerDTO == null) {
			return "findbyid-fail";
		} else {
			return "findbyid-success";
		}
	}
	
	// 내 코드 registerCustomer
	/*
	@PostMapping("registerCustomer.do")
	public String registerCustomer(String id, String name, String address, Model model) {
		CustomerDTO customerDTO = customerMapper.findCustomerById(id);
		if(customerDTO != null) {
			return "duplicate-id";
		}
		customerMapper.registerCustomer(new CustomerDTO(id, name, address));
		return "redirect:registerSuccess.do";
	}
	
	@RequestMapping("registerSuccess.do")
	public String registerSuccess() {
		return "register-success";
	}
	*/
	
	// 강사님 코드 registerCustomer
	@PostMapping("registerCustomer.do")
	public String registerCustomer(CustomerDTO customerDTO) {
		// 중복확인
		if( customerMapper.findCustomerById(customerDTO.getId()) == null) {
			customerMapper.registerCustomer(customerDTO);
			return "redirect:registerResult.do";
		} else {
			return "duplicate-id";
		}
	}
	
	@GetMapping("registerResult.do")
	public String registerResult() {
		return "register-success";
	}
}
