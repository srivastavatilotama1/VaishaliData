package com.igate.pl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.igate.dto.Product;
import com.igate.service.ProductService;

public class Client 
{	
	public static void main(String[] args)
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		ProductService productService=	context.getBean("service",ProductService.class);
		//ProductService productService=new ProductService();
		for(Product product:productService.getProductList())
		{			
			System.out.println(product);
		}
	}
}
