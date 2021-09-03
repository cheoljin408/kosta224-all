package test;

import java.sql.SQLException;

import model.ProductDAO;
import model.ProductDTO;

// 상품 정보를 등록 INSERT
public class TestProductDAO3 {
	public static void main(String[] args) {
		try {
			ProductDAO dao = new ProductDAO();
			ProductDTO dto = new ProductDTO("5", "카스", "OB", 1700);
			if(dao.existsById(Integer.parseInt(dto.getId()))) {
				System.out.println("상품이 존재하여 등록불가");
			}
			else {
				dao.register(dto);
				System.out.println("등록완료");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
