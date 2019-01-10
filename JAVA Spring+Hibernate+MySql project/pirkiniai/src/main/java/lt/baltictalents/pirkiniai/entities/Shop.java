package lt.baltictalents.pirkiniai.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="shops")
public class Shop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String image;

	@OneToMany(mappedBy="shop", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
	private List<Product> product;

	public Shop() {
		super();
	}

	public Shop(String name, String address, List<Product> product) {
		super();
		this.name = name;
		this.address = address;
		this.product = product;
	}

	public Shop(Integer id, String name, String address, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.product = product;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}


}
