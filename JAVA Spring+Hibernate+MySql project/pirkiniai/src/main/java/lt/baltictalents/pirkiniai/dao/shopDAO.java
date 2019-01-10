package lt.baltictalents.pirkiniai.dao;

import java.util.List;

import lt.baltictalents.pirkiniai.entities.Shop;

public interface shopDAO {
	
	public List<Shop> getShopList();
	public void deleteShop(int id);
	public void addShop(Shop shop);
	public Shop getShop(int id);
	public Shop updateShop(Shop shop);
}
