package com.igate.yescorp.controller;

import java.io.IOException;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.yescorp.bean.FirmBean;
import com.igate.yescorp.exception.FirmException;
import com.igate.yescorp.service.FirmRegisterService;
import com.igate.yescorp.service.IFirmRegisterService;

/**
 * Servlet implementation class FirmRegistration
 */
@WebServlet("/FirmRegistration")
public class FirmRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirmRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("operation");
		FirmBean firmBean = new FirmBean();
		HttpSession session = request.getSession();
		IFirmRegisterService firmRegister = new FirmRegisterService();
			if (operation.equalsIgnoreCase("home")) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("view/home.jsp");
				requestDispatcher.forward(request, response);
			} else if (operation.equalsIgnoreCase("regForm")) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("view/register.jsp");
				requestDispatcher.forward(request, response);
			} else if (operation.equalsIgnoreCase("activate")) {
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("view/activate.jsp");
				requestDispatcher.forward(request, response);
			} else if (operation.equalsIgnoreCase("register")) {
				String firstName = request.getParameter("firstName");
				String middleName = request.getParameter("middleName");
				String lastName = request.getParameter("lastName");
				String ownerName=firstName + " " + middleName + " " + lastName;
				
				String businessName = request.getParameter("businessName");
				String emailId = request.getParameter("emailId");
				String mobileNumber = request.getParameter("mobileNumber");
				firmBean.setOwnerName(ownerName);
				firmBean.setBusinessName(businessName);
				firmBean.setEmail(emailId);
				firmBean.setMobileNumber(mobileNumber);
				//errorList=firmRegister.isValid(firmBean);
				try {
					boolean status = firmRegister.registerFirm(firmBean);
					if(status){
						int activationCode=firmRegister.getActivationCode();
						session.setAttribute("activation", activationCode);
						session.setAttribute("emailId", firmBean.getEmail());
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/success.jsp");
						requestDispatcher.forward(request, response);
					}
				} catch (FirmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.setAttribute("errorMessage", e);
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/error.jsp");
					requestDispatcher.forward(request, response);
				}
			}else if(operation.equalsIgnoreCase("activation")){
				int code=Integer.parseInt(request.getParameter("activationCode"));
				String mail=request.getParameter("emailId");
				int actcode=(int) session.getAttribute("activation");
				String email=(String) session.getAttribute("emailId");
				if(code==actcode && mail.equalsIgnoreCase(email)){
					try {
						firmRegister.activateAccount(mail);
						request.setAttribute("date", new Date());
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/activated.jsp");
						requestDispatcher.forward(request, response);
					} catch (FirmException e) {
						// TODO Auto-generated catch block
						request.setAttribute("errorMessage", e);
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/error.jsp");
						requestDispatcher.forward(request, response);
					}
				}
				else{
					request.setAttribute("ErrorMessage", "Entered wrong code or email id");
					RequestDispatcher requestDispatcher=request.getRequestDispatcher("view/activate.jsp");
					requestDispatcher.forward(request, response);
				}
				
			}
	}
}
