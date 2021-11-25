package org.kosta.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	int getTotalProductCount();

	List<String> getMakerKindList();

	ProductVO findProductByNo(int productNo);

	List<ProductVO> findProductListByMakerAndPrice(ProductVO paramVO);

	List<ProductVO> findProductListLessThanPrice(int price);

	List<ProductVO> findProductListByLowPriceAndHighPrice(Map<String, Integer> paramMap);

	List<ProductVO> findProductListLikeKeyword(String keyword);

	void register(ProductVO vo);

	List<ProductVO> getAllProductList();

	void registerVer2(ProductVO vo);
}
