package com.cg.feedbackApplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.feedbackApplication.dto.Feedback;
import com.cg.feedbackApplication.exception.FeedbackException;
import com.cg.feedbackApplication.service.FeedbackService;
import com.cg.feedbackApplication.service.FeedbackServiceImpl;

/**
 * Servlet implementation class FeedbackController
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int visitorCount=0;

	ServletConfig config;
	ServletContext context;
	FeedbackService service= new FeedbackServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
		super.init(config);
	}
	public FeedbackController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		System.out.println("action in post ....: "+action );
		PrintWriter out=response.getWriter();


		if(action!=null )
		{
			if(action.equals("ShowLoginPage"))
			{
				context= config.getServletContext();
				Integer temp=(Integer)context.getAttribute("visitCount");
				if(temp==null){
					context.setAttribute("visitCount", visitorCount);
				}
				else{
					visitorCount++;
					context.setAttribute("visitCount", visitorCount);

				} 
				RequestDispatcher rd= request.getRequestDispatcher("/Login.jsp");
				rd.forward(request, response);
			}
			//show login page if ends 
			//**********************************************************
			if(action.equals("ValidateRole")){
				
				System.out.println("in login if...");
				String role= request.getParameter("role");
				if(role.equals("student"))
				{
					System.out.println("................................student");
					String name=request.getParameter("userName");
					request.setAttribute("userName", name);
					try 
					{
						ArrayList<String> facultyNameList= service.getAllFacultyNames();
						request.setAttribute("facultyNameList", facultyNameList);
						RequestDispatcher rd= request.getRequestDispatcher("/FeedbackPage.jsp");
						rd.forward(request,response);
					}
					catch (FeedbackException e)
					{
						request.setAttribute("error",e.getMessage());
						RequestDispatcher rd= request.getRequestDispatcher("/error.jsp");
						rd.forward(request, response);
					}
				}
						// if student  is role 
				if(role.equals("admin"))
				{
					String name=request.getParameter("userName");
					request.setAttribute("userName", name);
					RequestDispatcher rd= request.getRequestDispatcher("/Admin.jsp");
					rd.forward(request,response);			
				}
			}
			if(action.equals("addComment")){
				String fName= request.getParameter("facultyName");
				String comment= request.getParameter("comment");	
				try {
					Feedback bean= new Feedback();
					bean.setFacultyName(fName);
					bean.setComment(comment);
					int feedbackId= service.addComments(bean);
					request.setAttribute("feedbackId", feedbackId);
					RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
					rd.forward(request,response);
				} catch (FeedbackException e) {
					request.setAttribute("error",e.getMessage());
					RequestDispatcher rd= request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
			
				}
			}
		}
		else
		{
			out.println("No action defined");
		}
	}

}
