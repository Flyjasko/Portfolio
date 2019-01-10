package lt.baltictalents.pirkiniai.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max=100, message="Product name cannot exceed 100 letters !")
	@Column
	private String name;
	
	@Column
	private Integer amount;
	
	@Column
	private Integer type;
	
	@ManyToOne 
	@JoinColumn(name="shop_id")
	@JsonBackReference
	private Shop shop;
	
	@Column
	private String onPurchase;

	public Product() {
		super();
	}

	public Product(String name, Integer amount, Integer type, Shop shop, String onPurchase) {
		super();
		this.name = name;
		this.amount = amount;
		this.type = type;
		this.shop = shop;
		this.onPurchase = onPurchase;
	}
	
	public Product(Integer id, String name, Integer amount, Integer type, Shop shop, String onPurchase) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.type = type;
		this.shop = shop;
		this.onPurchase = onPurchase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getOnPurchase() {
		return onPurchase;
	}

	public void setOnPurchase(String onPurchase) {
		this.onPurchase = onPurchase;
	}
	
	

}
