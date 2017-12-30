package com.capgemini.salesmanagement.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.salesmanagement.bean.ProductBean;
import com.capgemini.salesmanagement.bean.SalesBean;
import com.capgemini.salesmanagement.exception.ProductException;
import com.capgemini.salesmanagement.service.IProductService;
import com.capgemini.salesmanagement.service.ProductService;



public class Client {

	static Scanner sc=new Scanner(System.in);
	static List<ProductBean> prodDetails = null;  
	static List<ProductBean> prodBill = null;  
	static IProductService productService=new ProductService();
	public static void main(String[] args) 
	{
		
		
		while(true)
		{
			System.out.println("1.Enter Details of product"
					+ "\n 2.Display details \n 3.Exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:  
			    productPurchase();  
			    break;  
			   case 2:  
			    getProductDetails();  
			    break;  
			   default:  
			    System.exit(0);  
			}
		}
	}

	public static void getProductDetails()  
	 {  
	  prodDetails = new ArrayList<ProductBean>();  
	  System.out.println("Enter the Product Code");  
	  String productCode = sc.next();  
	  int prodCode = Integer.parseInt(productCode);  
	  if(productService.checkProductCode(productCode))  
	  {  
	   int pCode = Integer.parseInt(productCode);  
	   try   
	   {  
	    if(productService.productCodeAvailable(pCode))  
	    {  
	     prodDetails = (List<ProductBean>) productService.getProductDetails(pCode);  
	     Iterator<ProductBean> prodIt =prodDetails.iterator();  
	     while(prodIt.hasNext())  
	     {  
	      System.out.println(prodIt);  
	     }  
	    }  
	   }   
	   catch (ProductException e)   
	   {  
	    e.printStackTrace();  
	   }
	  }  
	 }
	private static void productPurchase() 
	{
		SalesBean sales=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product Code you want to buy : ");
		String procode=sc.next();
		System.out.println("Enter how much quantity you want ?");
		int quant=sc.nextInt();
		int price = 0;  
		  int lineTotal = 0;  
		  if(quant > 0)  
		  {  
		   int prodCode = Integer.parseInt(procode);  
		   if(productService.checkProductCode(procode))  
		   {  
		    try   
		    {  
		     if(productService.productCodeAvailable(prodCode))  
		     {  
		      sales = new SalesBean();  
		      ProductBean product = new ProductBean();  
		      product = productService.getProductBill(prodCode);  
		      price = product.getProductPrice();  
		      lineTotal = (price*quant);  
		      sales.setLineTotal(lineTotal);  
		      sales.setQuantity(quant);  
		      sales.setProductCode(prodCode);  
		        
		      if(productService.insertSalesDetails(sales))  
		      {  
		       prodBill = new ArrayList<ProductBean>();  
		       System.out.println("Product Purchased sucessfully:");  
		       System.out.println("Billing Information:");  
		       System.out.println("Product Name:   " +product.getProductName());  
		       System.out.println("Product Category:  "+product.getProductCategory());  
		       System.out.println("Product description:" +product.getProductDescription());  
		       System.out.println("Product Price: "+product.getProductPrice());  
		       System.out.println("Quantity: "+quant);  
		       System.out.println("Line Total (Rs) "+lineTotal);  
		      }  
		     }  
		    }   
		    catch (ProductException e)  
		    {  
		     e.printStackTrace();  
		    }  
		   }  
		  }  
		  else   
		   System.err.println("Quantity Cannot be Negative,please give a valid quantity");  
		
	}

}
