package model;

public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	
	// DI(Dependency Injection): setter에 의존성 주입(spring ioc container가 bean or component or object를 주입)
	public void setProductDAO(ProductDAO productDAO) {
		System.out.println("setter DI: " + productDAO);
		this.productDAO = productDAO;
	}

	@Override
	public String findProductById(String id) {
		return productDAO.findProductById(id);
	}

}
