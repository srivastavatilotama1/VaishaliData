package com.igate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.igate.dao.ProductDAO;
import com.igate.dto.Product;
@Component("service")
public class ProductService  implements IProductService
{
	@Autowired
	@Qualifier("dao")// qualifieres specifies that what is the id of dependent id?
	private ProductDAO productDao;
	
	public List<Product> getProductList() 
	{
		return productDao.getProductList();
	}
	
	public ProductService()
	{
		//productDao=new ProductDAO();
	}

}
