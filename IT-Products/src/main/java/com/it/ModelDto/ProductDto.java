package com.it.ModelDto;

public class ProductDto {

	private long id;
	private Integer mss;
	private Integer ei;
	private Integer training;
	private double price;
	private String promocode;
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
	public double getPrice() {
	return  price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
}