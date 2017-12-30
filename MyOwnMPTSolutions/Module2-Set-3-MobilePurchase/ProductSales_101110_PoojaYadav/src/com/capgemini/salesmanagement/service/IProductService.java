package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.exception.ProductException;

public interface IProductService 
{
	ProductBean getProductDetails(int productCode) throws ProductException;
	boolean insertSalesDetails(SalesBean sbean) throws ProductException;
	boolean productCodeAvailable(int productCode) throws ProductException;
	
	
	ProductBean getProductBill(int productCode);
	boolean checkProductCode(String productCode);
}
