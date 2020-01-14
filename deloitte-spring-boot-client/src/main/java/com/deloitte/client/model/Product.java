package com.deloitte.client.model;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



public class Product {
	
	
	int prodId;
	String prodName;
	float price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate releaseDate;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String prodName, float price, LocalDate releaseDate) {
		super();
		
		this.prodName = prodName;
		this.price = price;
		this.releaseDate = releaseDate;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", releaseDate="
				+ releaseDate + "]";
	}
	

}
