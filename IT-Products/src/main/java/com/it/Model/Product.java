package com.it.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product{


	public Product() {
		super();
	}

	public Product(long id, Integer mss, Integer ei, Integer training, float price, String promocode) {
		super();
		this.id = id;
		this.mss = mss;
		this.ei = ei;
		this.training = training;
		this.price = price;
		this.promocode = promocode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private Integer mss;

	@Column
	private Integer ei;
	
	@Column
	private Integer training;
	
	@Column
	private float price;
	
	@Column
	private String promocode;

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", mss=" + mss + ", ei=" + ei + ", training=" + training + ", price=" + price
				+ ", promocode=" + promocode + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getMss() {
		return mss;
	}

	public void setMss(Integer mss) {
		this.mss = mss;
	}

	public Integer getEi() {
		return ei;
	}

	public void setEi(Integer ei) {
		this.ei = ei;
	}

	public Integer getTraining() {
		return training;
	}

	public void setTraining(Integer training) {
		this.training = training;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPromocode() {
		return promocode;
	}

	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	
}
