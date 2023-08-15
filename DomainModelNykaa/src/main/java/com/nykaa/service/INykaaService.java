package com.nykaa.service;

import java.util.List;
import com.nykaa.exceptions.ProductNotFoundException;
import com.nykaa.model.Product;

public interface INykaaService {
	
	//name,productId,category,price,offer
	
	//crud operation
	void addProduct(Product product);
	void updateProduct(int productId,double price);
	void deleteProduct(int productId);
	List<Product> getAll();
	List<Product> getByCategory(String category) throws ProductNotFoundException;
	List<Product> getByPriceLessThan(double price) throws ProductNotFoundException;
	List<Product> getByOfferMoreThan(int offer) throws ProductNotFoundException;
	Product getById(int productId) throws ProductNotFoundException;
	
	
	
}