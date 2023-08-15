package com.nykaa.dao;

import java.util.List;

import com.nykaa.exceptions.ProductNotFoundException;
import com.nykaa.model.Product;

public interface INykaaDao {
	//crud operation
		void addProduct(Product Product);
		void updateProduct(int ProductId,double price);
		void deleteProduct(int ProductId);
		
		List<Product> findAll();
		List<Product> findByCategory(String category) throws ProductNotFoundException;
		List<Product> findByPriceLessThan(double price) throws ProductNotFoundException;
		List<Product> findByOfferMoreThan(int offer) throws ProductNotFoundException;
		Product findById(int productId) throws ProductNotFoundException;

}
