package com.nykaa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nykaa.exceptions.ProductNotFoundException;
import com.nykaa.model.Product;
import com.nykaa.util.Queries;

public class NykaaDaoImpl implements INykaaDao{
	
	//name,category,productId,price,offer

	@Override
	public void addProduct(Product Product) {
		try (Connection connection= DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.INSERTQUERY);){
			statement.setString(1,Product.getName());
			statement.setString(2, Product.getCategory());
			statement.setInt(3, Product.getProductId());
			statement.setDouble(4, Product.getPrice());
			statement.setInt(5, Product.getOffer());
			statement.execute();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(int ProductId, double price) {
		try (Connection connection= DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.UPDATEQUERY);){
			statement.setInt(1, ProductId);
			statement.setDouble(2, price);
			statement.execute();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int ProductId) {
		try (Connection connection= DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.DELETEQUERY);){
			statement.setInt(1, ProductId);
			statement.execute();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//name,category,productId,price,offer
	@Override
	public List<Product> findAll() {
		List<Product> listOfProducts=new ArrayList<>();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERY);
				ResultSet rs=statement.executeQuery()){
			while(rs.next()) {
				String name=rs.getString("name");
				String cat=rs.getString("category");
				int productId=rs.getInt("productId");
				double price=rs.getDouble("price");
				int offer=rs.getInt("offer");
				Product product=new Product(name,cat,productId,price,offer);
				listOfProducts.add(product);
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProducts;
	}

	@Override
	public List<Product> findByCategory(String category) throws ProductNotFoundException {
		List<Product> listOfProducts=new ArrayList<>();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYCATEGORY);
				){
			statement.setString(1, category);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
			String name=rs.getString("name");
			String cat=rs.getString("category");
			int productId=rs.getInt("productId");
			double price=rs.getDouble("price");
			int offer=rs.getInt("offer");
			Product product=new Product(name,cat,productId,price,offer);
			listOfProducts.add(product);
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProducts;
	}

	@Override
	public List<Product> findByPriceLessThan(double price) throws ProductNotFoundException {
		List<Product> listOfProducts=new ArrayList<>();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYPRICE);
				){
			statement.setDouble(1, price);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
			String name=rs.getString("name");
			String cat=rs.getString("category");
			int productId=rs.getInt("productId");
			double price1=rs.getDouble("price");
			int offer=rs.getInt("offer");
			Product product=new Product(name,cat,productId,price1,offer);
			listOfProducts.add(product);
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProducts;
		
	}

	@Override
	public List<Product> findByOfferMoreThan(int offer) throws ProductNotFoundException {
		
		List<Product> listOfProducts=new ArrayList<>();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYOFFER);
				){
			statement.setInt(1, offer);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
			String name=rs.getString("name");
			String cat=rs.getString("category");
			int productId=rs.getInt("productId");
			double price=rs.getDouble("price");
			int offer1=rs.getInt("offer");
			Product product=new Product(name,cat,productId,price,offer1);
			listOfProducts.add(product);
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfProducts;
	}

	@Override
	public Product findById(int productId) throws ProductNotFoundException {

		Product product=new Product();
		try(Connection connection=DBConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYID);
				){
			statement.setInt(1, productId);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
			String name=rs.getString("name");
			String cat=rs.getString("category");
			int productId1=rs.getInt("productId");
			double price=rs.getDouble("price");
			int offer=rs.getInt("offer");
			product=new Product(name,cat,productId1,price,offer);
			}
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
}
