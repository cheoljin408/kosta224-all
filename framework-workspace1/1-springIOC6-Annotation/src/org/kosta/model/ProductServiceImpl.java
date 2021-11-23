package org.kosta.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	
	@Override
	public void register(String productInfo) {
		productDAO.register(productInfo);
	}
}
