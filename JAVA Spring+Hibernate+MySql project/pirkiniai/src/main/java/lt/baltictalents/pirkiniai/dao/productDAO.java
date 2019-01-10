package lt.baltictalents.pirkiniai.dao;

import java.util.List;

import lt.baltictalents.pirkiniai.entities.Product;
import lt.baltictalents.pirkiniai.entities.Shop;

public interface productDAO {
	
	public List<Product> getProductsByShop(int id);
	public void addProductByShop(Product product);
	public List<Product> getAllProducts();
	public void deleteProduct(int id);
	public void purchaseProduct(int id);
	public List<Product> getProductsByShopForHistory(int id);
	public List<Product> getAllProductsForHistory();
	public List<Product> searchForAProductByName(String name);

}
