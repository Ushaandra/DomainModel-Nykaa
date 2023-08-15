package com.nykaa.model;

public class Product {
	private String name;
	private String category;
	private Integer productId;
	private double price;
	private int offer;
	
	public Product() {
		super();
	}

	public Product(String name, String category, Integer productId, double price, int offer) {
		super();
		this.name = name;
		this.category = category;
		this.productId = productId;
		this.price = price;
		this.offer = offer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", productId=" + productId + ", price=" + price
				+ ", offer=" + offer + "]";
	}
	
	
	
	
	
}
