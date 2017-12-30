package com.ajax.controller;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
public class HelloServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public HelloServletController() {
        super();      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONObject json= new JSONObject();
		try {
			json.put("Name", "Vaishali Srivastava");
			json.put("empid", 821219);
			
			Date d= new Date();
			
			SimpleDateFormat sd= new SimpleDateFormat("dd/MMM/yyyy");
			String today=sd.format(d);
			json.put("date", today);
			json.put("location", "Pune");
			json.put("deptName", "Training");
			PrintWriter out= response.getWriter();
			System.out.println("response sent....");
			out.println(json.toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
