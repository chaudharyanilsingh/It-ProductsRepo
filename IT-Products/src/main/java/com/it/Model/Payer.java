package com.it.Model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Payer {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	private String paymentMethod;
	
	@Column
	private String status;
	
	@Column
	private String accountType;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private PayerInfo payerInfo;

	
	public Payer() {
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public PayerInfo getPayerInfo() {
		return payerInfo;
	}


	public void setPayerInfo(PayerInfo payerInfo) {
		this.payerInfo = payerInfo;
	}


}
