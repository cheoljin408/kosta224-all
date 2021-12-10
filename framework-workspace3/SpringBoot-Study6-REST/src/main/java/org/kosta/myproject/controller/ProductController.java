package org.kosta.myproject.controller;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.myproject.model.mapper.ProductMapper;
import org.kosta.myproject.model.vo.ProductVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@SuppressWarnings({ "unchecked", "rawtypes" }) //ResponseEntity generic warning message 제외 
// @Controller + @ResponseBody
@RestController
public class ProductController {
	@Resource
	private ProductMapper productMapper;
	@GetMapping("/products")
	public List getAllProductList() {
		System.out.println("Request Method : GET");
		return productMapper.getAllProductList();
	}
	/*
	 *  @PathVariable : url 정보를 변수로 할당받기 위한 어노테이션 
	 *  				   {id} 자리에 해당 어노테이션이 선언된 변수로 데이터가 할당된다
	 *  
	 *  ResponseEntity : 반환값에 상태코드와 응답 메세지를 주고 싶을 때 사용
	 *  
	 */
	
	
	
	
	@PostMapping(value = "/products")
	public ResponseEntity registerProduct( ProductVO productVO) {
		System.out.println("Request Method : POST");
		productMapper.registerProduct(productVO);	
		//return new ResponseEntity(productVO.getId()+" "+productVO.getName()+" 상품등록완료", HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).body(productVO.getId()+" "+productVO.getName()+" 상품등록완료");
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity deleteProduct(@PathVariable String id) {
		System.out.println("Request Method : DELETE");
		if (productMapper.deleteProduct(id)==0) {
			return new ResponseEntity(id+"상품 아이디에 대한 상품이 없어 삭제 불가", HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity(id+" id 상품정보삭제완료", HttpStatus.OK);
	}
	@PutMapping("/products")
	public ResponseEntity updateProduct(ProductVO productVO) {
		System.out.println("Request Method : PUT "+productVO);
		int result= productMapper.updateProduct(productVO);
		if (result==0) {
			return new ResponseEntity(productVO.getId()+"번 상품 아이디에 대한 상품이 없어 수정불가", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(productVO.getId()+" id 상품정보수정완료", HttpStatus.OK);
	}
}









