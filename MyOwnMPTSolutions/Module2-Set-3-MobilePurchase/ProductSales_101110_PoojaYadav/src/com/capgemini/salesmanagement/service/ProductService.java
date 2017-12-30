package com.capgemini.salesmanagement.service;



import java.util.regex.Pattern;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.dao.IProductDAO;
import com.capgemini.salesmanagement.dao.ProductDAO;
import com.capgemini.salesmanagement.exception.ProductException;

public class ProductService implements IProductService
{
	IProductDAO productDAO=new ProductDAO();
	public ProductService() {}  
	@Override
	public ProductBean getProductDetails(int productCode) throws ProductException {
		
		return productDAO.getProductDetails(productCode);
	}

	@Override
	public boolean insertSalesDetails(SalesBean sbean) throws ProductException
	{
		
		return productDAO.insertSalesDetails(sbean);
	}

	

	@Override
	public boolean checkProductCode(String productCode) {
		
		String pat1="[1][0-9]{3}";  
		  if(Pattern.matches(pat1, productCode))  
		  {  
		   return true;  
		  }  
		  else  
		  {  
		   System.out.println("Invalid product code");  
		   return false;  
		  }  
	}

	
	  
	 @Override  
	 public ProductBean getProductBill(int productCode)  
	 {  
	  return productDAO.getProductBill(productCode);  
	 }  
	 
	 @Override  
	 public boolean productCodeAvailable(int productCode)throws ProductException  
	 {  
	  return productDAO.productCodeAvailable(productCode);  
	 }  
	
}
