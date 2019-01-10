package lt.baltictalents.pirkiniai.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lt.baltictalents.pirkiniai.dao.shopDAO;
import lt.baltictalents.pirkiniai.entities.Shop;

@Service
public class shopServiceImpl implements shopService {

	@Autowired
	shopDAO sDAO;

	@Override
	@Transactional
	public List<Shop> getShopList() {
		return sDAO.getShopList();
	}

	@Override
	@Transactional
	public void deleteShop(int id) {
		sDAO.deleteShop(id);
	}

	@Override
	@Transactional
	public void addShop(Shop shop) {
		sDAO.addShop(shop);
	}

	@Override
	@Transactional
	public Shop getShop(int id) {
		return sDAO.getShop(id);
	}

	@Override
	@Transactional
	public Shop updateShop(Shop shop) {
		return sDAO.updateShop(shop);
	}
}
