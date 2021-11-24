package org.kosta.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	int getTotalProductCount();

	List<String> getMakerKindList();

	ProductVO findProductByNo(int productNo);

	List<ProductVO> findProductListByMakerAndPrice(ProductVO paramVO);
}
