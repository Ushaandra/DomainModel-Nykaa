package com.nykaa.service;

import java.util.List;

import com.nykaa.dao.INykaaDao;
import com.nykaa.dao.NykaaDaoImpl;
import com.nykaa.exceptions.ProductNotFoundException;
import com.nykaa.model.Product;

public class NykaaServiceImpl implements INykaaService{

	INykaaDao nykaaDao=new NykaaDaoImpl();
	
	@Override
	public void addProduct(Product product) {
		nykaaDao.addProduct(product);
	}

	@Override
	public void updateProduct(int productId, double price) {
		nykaaDao.updateProduct(productId, price);
	}

	@Override
	public void deleteProduct(int productId) {
		nykaaDao.deleteProduct(productId);
	}

	@Override
	public List<Product> getAll() {
		return nykaaDao.findAll();
	}

	@Override
	public List<Product> getByCategory(String category) throws ProductNotFoundException {
		List<Product> products=nykaaDao.findByCategory(category);
		if(products.size()==0)
			throw new ProductNotFoundException();
		return products;
	}

	@Override
	public List<Product> getByPriceLessThan(double price) throws ProductNotFoundException {

		List<Product> products=nykaaDao.findByPriceLessThan(price);
		if(products.size()==0)
			throw new ProductNotFoundException();
		return products;
	}

	@Override
	public List<Product> getByOfferMoreThan(int offer) throws ProductNotFoundException {

		List<Product> products=nykaaDao.findByOfferMoreThan(offer);
		if(products.size()==0)
			throw new ProductNotFoundException();
		return products;
	}

	@Override
	public Product getById(int productId) throws ProductNotFoundException {

		Product product=nykaaDao.findById(productId);
		if(product==null)
			throw new ProductNotFoundException();
		
		return product;
	}

	

}
