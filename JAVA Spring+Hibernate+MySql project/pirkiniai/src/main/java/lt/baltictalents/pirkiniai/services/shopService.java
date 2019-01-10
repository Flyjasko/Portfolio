package lt.baltictalents.pirkiniai.services;

import java.util.List;

import lt.baltictalents.pirkiniai.entities.Shop;

public interface shopService {
	
	public List<Shop> getShopList();
	public void deleteShop(int id);
	public void addShop(Shop shop);
	public Shop getShop(int id);
	public Shop updateShop(Shop shop);
}
