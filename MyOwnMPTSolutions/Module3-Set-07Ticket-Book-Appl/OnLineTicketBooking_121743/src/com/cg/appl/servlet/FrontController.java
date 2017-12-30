/*********************************************************************
 * File                 : FrontController.java
 * Author Name          : NIKHIL PANDEY
 * Desc                 : FrontController of Application
 * Version              : 1.0
 * Creation Date        : 14-Mar-2017
 * Last Modified Date   : 14-Mar-2017
 *********************************************************************/
package com.cg.appl.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.appl.Exception.BookingException;
import com.cg.appl.dto.ShowDetails;
import com.cg.appl.service.TicketBookingServiceImpl;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher requestDispatcher;
	private String nextJspString;
	String msg = null;
	TicketBookingServiceImpl tImpl;// Service for TicketBooking
	private ServletContext ctxContext;

	public void init() throws ServletException {
		ctxContext = super.getServletContext();
		tImpl = new TicketBookingServiceImpl();
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();

		switch (command) {
		case "/showDetails.do": {
			//SHOWING DETAILS
			log("Showing List of Show");
			List<ShowDetails> list;
			try {
				list = tImpl.showDetails();
				request.setAttribute("list", list);
			} catch (BookingException e) {
				
				e.printStackTrace();
			}
			nextJspString = "/showDetails.jsp";
		}
			break;
		case "/book.do": {
			//Booking Form
			log("Displaying Booking Form");
			String showid = request.getParameter("id");
			String showname = request.getParameter("showname");
			Double priceticket = Double.parseDouble(request
					.getParameter("priceticket"));
			int avseats = Integer.parseInt(request.getParameter("avseats"));

			HttpSession session = request.getSession(true);
			session.setAttribute("showid", showid);

			ShowDetails showDetails = new ShowDetails(showid, showname,
					avseats, priceticket);
			request.setAttribute("list", showDetails);

			nextJspString = "/bookNow.jsp";

		}
			break;

		case "/updateDeatils.do": {
			//Updating And Booking Ticket
			log("Trying to book Ticket");
			HttpSession session = request.getSession(false);
			String showid = (String) session.getAttribute("showid");
			session.invalidate();
			String showname = request.getParameter("showname");
			Double priceticket = Double.parseDouble(request
					.getParameter("priceticket"));
			int avseats = Integer.parseInt(request.getParameter("avseats"));

			ShowDetails showDetails = new ShowDetails(showid, showname,
					avseats, priceticket);

			String name = request.getParameter("name");
			String mobile = request.getParameter("mobile");
			String seats = request.getParameter("seats");
			Double totalprice = Integer.parseInt(seats) * priceticket;

			HttpSession session1 = request.getSession(true);
			session1.setAttribute("showid", showid);
			session1.setAttribute("showname", showname);
			session1.setAttribute("totalprice", totalprice);
			session1.setAttribute("seats", seats);
			session1.setAttribute("name", name);
			session1.setAttribute("mobile", mobile);
			session1.setAttribute("seats", seats);
			try {
				if (tImpl.upadteShow(showDetails, Integer.parseInt(seats))) {
					log("Successfully Ticket is Booked");
					nextJspString = "/success.jsp";
				}
			} catch (NumberFormatException | BookingException e) {
				// TODO Auto-generated catch block
				log("BOOKING EXCEPTION OCCURED");
				request.setAttribute("errorMsg", e);
				nextJspString = "/error.jsp";

			}

		}
			break;
		}
		requestDispatcher = request.getRequestDispatcher(nextJspString);
		requestDispatcher.forward(request, response);

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
