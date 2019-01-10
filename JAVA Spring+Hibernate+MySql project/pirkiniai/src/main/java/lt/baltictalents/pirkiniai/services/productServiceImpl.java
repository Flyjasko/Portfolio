package lt.baltictalents.pirkiniai.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.baltictalents.pirkiniai.dao.productDAO;
import lt.baltictalents.pirkiniai.entities.Product;
import lt.baltictalents.pirkiniai.entities.Shop;

@Service
public class productServiceImpl implements productService {
	
	@Autowired
	productDAO pDAO;

	@Override
	@Transactional
	public List<Product> getProductsByShop(int id) {
		return pDAO.getProductsByShop(id);
	}

	@Override
	@Transactional
	public void addProductByShop(Product product) {
		pDAO.addProductByShop(product);
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return pDAO.getAllProducts();
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		pDAO.deleteProduct(id);
	}

	@Override
	@Transactional
	public void purchaseProduct(int id) {
		pDAO.purchaseProduct(id);		
	}

	@Override
	@Transactional
	public List<Product> getProductsByShopForHistory(int id) {
		return pDAO.getProductsByShopForHistory(id);
	}

	@Override
	@Transactional
	public List<Product> getAllProductsForHistory() {
		return pDAO.getAllProductsForHistory();
	}

	@Override
	@Transactional
	public List<Product> searchForAProductByName(String name) {
		return pDAO.searchForAProductByName(name);
	}

}
