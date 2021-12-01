package org.kosta.springmvc04.controller;

import java.util.List;

import org.kosta.springmvc04.model.domain.ItemDTO;
import org.kosta.springmvc04.model.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private ItemMapper itemMapper;
	
	@Autowired
	public HomeController(ItemMapper mapper) {
		super();
		this.itemMapper = mapper;
	}
	
	@RequestMapping("home.do")
	public String home(Model model) {
		model.addAttribute("totalItemCount", itemMapper.getTotalItemCount());
		return "index";
	}
	
	// findItemByNo.do
	// 내 코드
	/*
	@RequestMapping("findItemByNo.do")
	public String findItemByNo(int itemNo, Model model) {
		ItemDTO dto = itemMapper.findItemByNo(itemNo);
		
		if(dto == null) {
			return "findbyno-fail";
		}
		
		model.addAttribute("itemDTO", dto);
		return "findbyno-success";
	}
	*/
	
	// 강사님 코드
	@RequestMapping("findItemByNo.do")
	public String findItemByNo(int itemNo, Model model) {
		String viewName = null;
		ItemDTO item = itemMapper.findItemByNo(itemNo);
		
		if(item == null) {
			viewName = "findbyno-fail";
		} else {
			viewName = "findbyno-success";
			model.addAttribute("itemDTO", item);
		}
		return viewName;
	}
	
	@RequestMapping("getAllItemList.do")
	public String getAllItemList(Model model) {
		List<ItemDTO> list = itemMapper.getAllItemList();
		model.addAttribute("itemList", list);
		
		return "item-list";
	}
	
	// registerItem.do
	// 내 코드
	/*
	@PostMapping("registerItem.do")
	public String registerItem(ItemDTO itemDTO) {
		itemMapper.registerItem(itemDTO);
		
		return "redirect:registerItemResult.do?itemNo=" + itemDTO.getItemNo();
	}
	
	@RequestMapping("registerItemResult.do")
	public String registerItemResult(String itemNo, Model model) {
		ItemDTO itemDTO = itemMapper.findItemByNo(Integer.parseInt(itemNo));
		model.addAttribute("itemDTO", itemDTO);
		return "register-item-result";
	}
	*/
	
	// 강사님 코드
	@PostMapping("registerItem.do")
	public String registerItem(ItemDTO itemDTO) {
		itemMapper.registerItem(itemDTO);
		
		return "redirect:registerItemResult.do?itemNo=" + itemDTO.getItemNo();
	}
	
	@RequestMapping("registerItemResult.do")
	public String registerItemResult(int itemNo, Model model) {
		model.addAttribute("itemDTO", itemMapper.findItemByNo(itemNo));
		return "register-item-result";
	}
}
