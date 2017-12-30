package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.dto.PlayerBean;
import com.cg.exception.CricketException;
import com.cg.service.CricketServiceImpl;
import com.cg.service.ICricketServiceImpl;

@WebServlet("*.obj")
public class CricketScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
/****************************************************************************
-Method Name : doGet
-Input parameters : request, response
-Return Type : -
-Throws : ServletException, IOException
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : doGet method calling doPost.
****************************************************************************/
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response); // calling doPost method.
	}
	
/****************************************************************************
-Method Name : doPost
-Input parameters : request, response
-Return Type : -
-Throws : ServletException, IOException
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : handling the switch cases.
****************************************************************************/

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String path = request.getServletPath().trim();
		String target = "";

		ICricketServiceImpl cricketServiceImpl = null;
		PlayerBean playerBean = null;

		switch (path) { // switch cases.

		case "/home.obj":
			target = "/home.jsp";
			break;

		case "/add.obj":
			target = "view/newPlayer.jsp";
			break;

		case "/newPlayer.obj":

			/** retrieving the form parameters **/

			String ename = request.getParameter("ename");

			Date dob = null;
			try {
				dob = new SimpleDateFormat("yyyy-MM-dd").parse(request
						.getParameter("edob"));
			} catch (ParseException e1) {

				e1.printStackTrace();
			}
			
			//declaring variables.
			
			String eloc = request.getParameter("eloc");
			String style = request.getParameter("style");
			int centuries = Integer.parseInt(request.getParameter("centuries"));
			int matches = Integer.parseInt(request.getParameter("matches"));
			int runs = Integer.parseInt(request.getParameter("runs"));

			playerBean = new PlayerBean();
			
			
			//setting values in variables.
			
			playerBean.setPlayerName(ename);
			playerBean.setDob(dob);
			playerBean.setCountry(eloc);
			playerBean.setBattingStyle(style);
			playerBean.setCenturies(centuries);
			playerBean.setMatches(matches);
			playerBean.setTotalRunScore(runs);

			cricketServiceImpl = new CricketServiceImpl();

			boolean flag = false;
			try {
				flag = cricketServiceImpl.validate(playerBean);
			} catch (CricketException exception) {
				request.setAttribute("error", exception);
				target = "view/error.jsp";
			}

			try {

				if (flag == true) {
					int playerId = cricketServiceImpl.addPlayer(playerBean);
					getServletContext().setAttribute("playerId", playerId);
					target = "view/insertSuccess.jsp";
				} else {
					target = "view/error.jsp";
				}
			} catch (CricketException exception) {
				request.setAttribute("error", exception);
				target = "view/error.jsp";
			}

			break;

		case "/retrieve.obj":
			cricketServiceImpl = new CricketServiceImpl();

			try {
				List<PlayerBean> playerList = cricketServiceImpl.viewPlayers();
				getServletContext().setAttribute("playerList", playerList);
				target = "view/viewPlayers.jsp";
			} catch (CricketException e) {
				request.setAttribute("error", e);
				target = "view/error.jsp";
			}
			break;

		default:
			break;

		} // switch ends
		RequestDispatcher dispatcher = request.getRequestDispatcher(target);
		dispatcher.forward(request, response);

	}
}
