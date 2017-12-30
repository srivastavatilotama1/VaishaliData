package com.capgemini.salesmanagement.junit;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.dao.IProductDAO;
import com.capgemini.salesmanagement.dao.ProductDAO;
import com.capgemini.salesmanagement.exception.ProductException;


public class ProductDAOTest 
{
	static IProductDAO prodDAO=null;
	
	@BeforeClass
	public static void beforeAllTest()
	{
		prodDAO = new ProductDAO();
	}
	
	@Test
	public void insertSalesDetails(SalesBean sbean)
	{
		ProductBean pro=new ProductBean();
		pro.setProductCode(1005);
		pro.setProductName("Phone");
		pro.setProductCategory("Electronics");
		pro.setProductDescription("Smartphone");
		pro.setProductPrice(40000);
		
		try
		{
			Assert.assertEquals(1, prodDAO.insertSalesDetails(sbean));
			
		}
		catch(ProductException e)
		{
			e.printStackTrace();
		}
	}
}
