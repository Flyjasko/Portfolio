package lt.baltictalents.pirkiniai.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lt.baltictalents.pirkiniai.entities.Product;
import lt.baltictalents.pirkiniai.entities.Shop;

@Repository
public class productDAOimpl implements productDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Product> getProductsByShop(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product where shop_id=:id AND onPurchase=null").setParameter("id", id).list();
		return products;
	}
	
	@Override
	public void addProductByShop(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product where onPurchase=null").list();
		return products;
	}
	
	@Override
	public void deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Product.class, id));
	}

	@Override
	public void purchaseProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createNativeQuery("UPDATE products SET onPurchase=NOW() WHERE id=?");
		query.setParameter(1, id);
		query.executeUpdate();
	}
	
	@Override
	public List<Product> getProductsByShopForHistory(int id) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product where shop_id=:id AND onPurchase IS NOT NULL").setParameter("id", id).list();
		return products;
	}
	
	@Override
	public List<Product> getAllProductsForHistory() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product where onPurchase IS NOT NULL").list();
		return products;
	}

	@Override
	public List<Product> searchForAProductByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Query<Product> query = session.createQuery("from Product where name LIKE ?1 AND onPurchase IS NOT NULL");
		query.setParameter(1, "%"+name+"%");		
		List<Product> products = query.getResultList();
		return products;
	}
}
