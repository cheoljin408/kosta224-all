package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.ProductVO;

@Mapper
public interface ProductMapper {
	public List<ProductVO> getAllProductList();
	public ProductVO findProductById(String id);
	public void registerProduct(ProductVO productVO);
	public int updateProduct(ProductVO productVO);
	public int deleteProduct(String id);
}
