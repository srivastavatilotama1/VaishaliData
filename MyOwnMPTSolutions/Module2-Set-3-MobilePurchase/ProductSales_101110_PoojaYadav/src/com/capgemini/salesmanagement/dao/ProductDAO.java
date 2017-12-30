package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.exception.ProductException;
import com.capgemini.salesmanagement.util.DBUtil;


public class ProductDAO implements IProductDAO
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	Logger productLogger;
	
	public ProductDAO()
	{
		PropertyConfigurator.configure("log4j.properties");
		productLogger=Logger.getLogger(ProductDAO.class);
		con=DBUtil.getCon();
	}
	
	 @Override  
	 public boolean insertSalesDetails(SalesBean sales)   
	 {  
	  con=DBUtil.getCon();  
	  int dataInserted =0;  
	  String insertQuery = "insert into sales values(product_sales_seq.nextval,?,?,SYSDATE,?)";  
	  try  
	  {  
	   pst = con.prepareStatement(insertQuery);  
	   pst.setInt(1, sales.getProductCode());  
	   pst.setInt(2, sales.getQuantity());  
	   pst.setInt(3,sales.getLineTotal());  
	  
	   dataInserted = pst.executeUpdate();  
	  }   
	  catch (SQLException e)   
	  {  
	   e.printStackTrace();  
	  }  
	  finally  
	  {  
	   try   
	   {  
	    pst.close();  
	    con.close();  
	   }  
	   catch (SQLException e)  
	   {  
	    e.printStackTrace();  
	   }  
	  }  
	  
	  if(dataInserted==1)  
	   return true;  
	  else  
	   return false;  
	 }  
	  
	 @Override  
	 public boolean productCodeAvailable(int productCode)throws ProductException   
	 {  
	  con=DBUtil.getCon();  
	  int temp = 0;  
	  String checkQuery = "select product_code from product where product_code = ?";  
	  try  
	  {  
	   pst = con.prepareStatement(checkQuery);  
	   pst.setInt(1, productCode);  
	   rs = pst.executeQuery();  
	   rs.next();  
	  
	   if(rs.getInt(1)==productCode)  
	    temp++;  
	  }   
	  catch (SQLException e)  
	  {  
	   e.printStackTrace();  
	  }  
	  finally  
	  {  
	   try   
	   {  
	    pst.close();  
	    rs.close();  
	    con.close();  
	   }  
	   catch (SQLException e)  
	   {  
	    e.printStackTrace();  
	   }  
	  }  
	  if(temp==1)  
	   return true;  
	  else   
	  {  
	   System.err.println("The Product Code does not Exist in the Table");  
	   return false;  
	  }  
	 }  
	  
	 @Override  
	 public ProductBean getProductBill(int productCode)  
	 {  
	  con=DBUtil.getCon();  
	  String getPrice = "select * from product where product_code =?";  
	  ProductBean p = new ProductBean();  
	  try   
	  {  
	   pst = con.prepareStatement(getPrice);  
	   pst.setInt(1, productCode);  
	   rs = pst.executeQuery();  
	   rs.next();  
	   p.setProductName(rs.getString(2));  
	   p.setProductCategory(rs.getString(3));  
	   p.setProductDescription(rs.getString(4));  
	   p.setProductPrice(rs.getInt(5));  
	  }   
	  catch (SQLException e)   
	  {  
	   e.printStackTrace();  
	  }  
	  
	  return p;  
	 }  
	 @Override  
	 public ProductBean getProductDetails(int productCode)throws ProductException   
	 {  
	  con=DBUtil.getCon();  
	  List<ProductBean> productDetail = new ArrayList<ProductBean>();  
	  ProductBean product = null;  
	  String selectQuery = "select * from product";  
	  try   
	  {  
	   st = con.createStatement();  
	   rs = st.executeQuery(selectQuery);  
	   while(rs.next())  
	   {  
	    product = new ProductBean();  
	  
	    product.setProductCode(rs.getInt(1));  
	    product.setProductName(rs.getString(2));  
	    product.setProductCategory(rs.getString(3));  
	    product.setProductDescription(rs.getString(4));  
	    product.setProductPrice(rs.getInt(5));  
	  
	    productDetail.add(product);  
	   }  
	  
	  }  
	  catch (SQLException e)  
	  {  
	   e.printStackTrace();  
	  }  
	  finally  
	  {  
	   try   
	   {  
	    st.close();  
	    rs.close();  
	    con.close();  
	   }  
	   catch (SQLException e)  
	   {  
	    e.printStackTrace();  
	   }  
	  }  
	  
	  return product;  
	 }  
	  
	  
	}  
