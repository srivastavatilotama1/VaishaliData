package com.igate.dao;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.igate.dto.Product;

@Component("dao")
public class ProductDAO  implements IProductDAO
{
	private List<Product>productList=new ArrayList<Product>();

	public List<Product> getProductList() 
	{
	 	setProductList();
	 	return productList;
	}

	public void setProductList() 
	{
		productList.add(new Product(222,"Remote",500));
		productList.add(new Product(111,"Monitor",2500));
		productList.add(new Product(333,"Marker",600));
	}
}