package lt.baltictalents.pirkiniai.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lt.baltictalents.pirkiniai.entities.Shop;

@Repository
public class shopDAOimpl implements shopDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Shop> getShopList() {
		Session session = sessionFactory.getCurrentSession();
		Query<Shop> query = session.createQuery("from Shop", Shop.class);
		List<Shop> shopList = query.getResultList();
		return shopList;
	}

	@Override
	public void deleteShop(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Shop.class, id));
	}

	@Override
	public void addShop(Shop shop) {
		Session session = sessionFactory.getCurrentSession();
		session.save(shop);	
	}

	@Override
	public Shop getShop(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Shop.class, id);
	}

	@Override
	public Shop updateShop(Shop shop) {
		Session session = sessionFactory.getCurrentSession();
		Shop merged = null;
		if(shop.getImage() == null) {
			merged = session.get(Shop.class, shop.getId());
			String img = merged.getImage();
			merged = (Shop) session.merge(shop);
			merged.setImage(img);
			session.update(merged);
			return merged;
		} else {
			session.update(shop);
			return shop;
		}
	}
}
