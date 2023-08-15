package com.nykaa.util;

//name,category,productId,price,offer
public class Queries {
	public static final String CREATEQUERY=
			"create table product(name varchar(20),category varchar(20),productId integer primary key,price double,offer int)";
	
	public static final String UPDATEQUERY=
			"update product set price=? where productId=?";
	public static final String DELETEQUERY=
			"delete from product where productId=?";
	
	public static final String INSERTQUERY=
			"insert into product(name,category,productId,price,offer) values(?,?,?,?,?)";
	
	public static final String QUERY=
			"select * from product";
	
	public static final String QUERYBYID=
			"select * from product where productId=?";
	
	public static final String QUERYBYCATEGORY=
			"select * from product where category=?";
	
	public static final String QUERYBYPRICE=
			"select * from product where price<?";
	
	public static final String QUERYBYOFFER=
			"select * from product where offer>?";
	
	

}
