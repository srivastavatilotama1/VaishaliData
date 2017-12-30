package com.igate.basic.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class HelloWorldAction  extends ActionSupport 
implements    ServletRequestAware
{
	private String name;
	private ArrayList cityList;
	
	private HttpServletRequest request;
	
	public HelloWorldAction(){
		System.out.println("**********In Constructor****************************");
		System.out.println("HelloWorldAction Constructor Invoked");};

	public String execute() throws Exception 
	{
		//int	charAtTen=name.charAt(100);
		//System.out.println(" Char At 100  : ");
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String, Object> context = new HashMap<String, Object>();

		context.put("surnameKey", new String("Srivastava")); 
		context.put("locationKey", new String("Pune MS"));
		System.out.println("Before Push");
		stack.push(context);
		System.out.println("After Push");

		System.out.println("Size of the valueStack: " + stack.size());

		System.out.println("********End Of Execute***********************");		

		return "success";
	}

	public String getName() {
		System.out.println("get  name is : "+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		System.out.println("set server request...........");
		this.request=request;

	}
}