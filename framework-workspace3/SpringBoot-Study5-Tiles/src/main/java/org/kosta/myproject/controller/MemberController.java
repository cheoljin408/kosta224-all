package org.kosta.myproject.controller;

import org.kosta.myproject.model.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {	
	private MemberMapper memberMapper;	
	@Autowired
	public MemberController(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
	// tiles-config.xml 설정 
	//  <definition name="*/*.tiles" extends="home.tiles">
	//	<put-attribute name="title" value="{2}" />
	//	<put-attribute name="main" value="/WEB-INF/views/{1}/{2}.jsp"/>
	//  </definition>	
	@RequestMapping("findMemberByIdForm")
	public String findMemberByIdForm(Model model) {		
		return "member/findbyid-form.tiles";
	}
	@RequestMapping("findMemberById")
	public String findMemberById(String id,Model model) {
		model.addAttribute("memberDTO", memberMapper.findMemberById(id));
		return "member/findbyid-result.tiles";
	}
	
	@RequestMapping("findMemberByAddressForm")
	public String findMemberByAddressForm(Model model) {
		model.addAttribute("addressList", memberMapper.getMemberAddressKind());
		return "member/findbyaddress-form.tiles";
	}
	
	@RequestMapping("findMemberByAddress")
	public String findMemberByAddress(Model model, String address) {
		model.addAttribute("memberList", memberMapper.findMemberByAddress(address));
		return "member/findbyaddress-result.tiles";
	}
	
}









