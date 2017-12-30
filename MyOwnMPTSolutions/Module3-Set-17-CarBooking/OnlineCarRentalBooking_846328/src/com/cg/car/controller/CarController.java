package com.cg.car.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.car.dto.Booking;
import com.cg.car.dto.CarDetails;
import com.cg.car.exception.CarException;
import com.cg.car.service.CarService;
import com.cg.car.service.CarServiceImpl;

/**
 * Servlet implementation class CarController
 */
@WebServlet(urlPatterns = { "/CarDetails", "/Buy", "/Purchase" })
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarService serv=new CarServiceImpl();
		
		String path = request.getServletPath();
		if (path.equals("/CarDetails")) {
			try {
				List<CarDetails> carlist = serv.getAllCarDetails();
				if (carlist.size() > 0) {
					request.setAttribute("carlist", carlist);
					RequestDispatcher disp = request
							.getRequestDispatcher("CarDetails.jsp");
					disp.forward(request, response);
				} else {
					request.setAttribute("error", "NO cars are available");
					RequestDispatcher disp = request
							.getRequestDispatcher("Error.jsp");
					disp.forward(request, response);
				}
			} catch (CarException e) {
				request.setAttribute("error", e.getMessage());
				RequestDispatcher disp = request
						.getRequestDispatcher("Error.jsp");
				disp.forward(request, response);
			}
	} else if (path.equals("/Buy")) {

	String carid = request.getParameter("carid");
	
	try {
		CarDetails car = serv.getCarId(carid);
		HttpSession sess = request.getSession(true);
		sess.setAttribute("carid", carid);
		RequestDispatcher disp = request
				.getRequestDispatcher("BookCar.jsp");
		disp.forward(request, response);
	} catch (NumberFormatException | CarException e) {
		request.setAttribute("error", e.getMessage());
		RequestDispatcher disp = request
				.getRequestDispatcher("Error.jsp");
		disp.forward(request, response);
	}

} else if (path.equals("/Purchase")) {
	Booking booking = new Booking();
	booking.setName(request.getParameter("name"));
	booking.setEmail(request.getParameter("maildId"));
	booking.setMobileNumber(request.getParameter("phoneno"));
	booking.setAddress(request.getParameter("address"));
	HttpSession sess = request.getSession(false);
	String car = (String) sess.getAttribute("carid");
	
	

	try {
		
		long Bid=serv.insertBookingDetails(booking,car);
		request.setAttribute("Bid", Bid);
		RequestDispatcher disp = request
				.getRequestDispatcher("success.jsp");
		disp.forward(request, response);
	} catch (CarException e) {
		request.setAttribute("error", e.getMessage());
		RequestDispatcher disp = request
				.getRequestDispatcher("Error.jsp");
		disp.forward(request, response);
	}
}

}
}
