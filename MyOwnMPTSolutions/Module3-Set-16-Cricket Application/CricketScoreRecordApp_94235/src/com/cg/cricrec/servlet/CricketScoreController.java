package com.cg.cricrec.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.cricrec.dto.CricketScoreDTO;
import com.cg.cricrec.exception.CricketScoreException;
import com.cg.cricrec.service.CricketServiceImpl;

/**
 * Servlet implementation class CricketScoreController
 */
@WebServlet("/CricketScoreController")
public class CricketScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CricketScoreDTO cricketScoredto =null;
		CricketServiceImpl cricketServiceImpl = null;
		
		String action = request.getParameter("action");
		
		if(action.equals("fetch"))
		{
			cricketServiceImpl = new CricketServiceImpl();
			List<CricketScoreDTO> recList = new ArrayList<CricketScoreDTO>();
			
			try
			{
				recList = cricketServiceImpl.fetchList();
				request.setAttribute("CricList", recList);
				RequestDispatcher rd;
				rd= request.getRequestDispatcher("jsp/viewPlayer.jsp");
				rd.forward(request, response);
			} 
			
			catch (CricketScoreException e) {
				
				request.setAttribute("error", e.getMessage());
				RequestDispatcher rd;
				rd= request.getRequestDispatcher("jsp/insertError.jsp");
				rd.forward(request, response);
			}
		}
		
		else if(action.equals("insert"))
		{
			RequestDispatcher rd;
			rd= request.getRequestDispatcher("jsp/newPlayer.jsp");
			rd.forward(request, response);
		}
		
		else if(action.equals("store"))
		{
			 String playerName = request.getParameter("name");
			 String dob = request.getParameter("dob");
			 String team = request.getParameter("team");
			 String battingstyle = request.getParameter("batstyle");
			 int  centuries = Integer.parseInt(request.getParameter("century"));
			 int matchesplayed = Integer.parseInt(request.getParameter("matchplayed"));
			 int totalScore = Integer.parseInt(request.getParameter("runscore"));
			 int result=0;
			 
			 
			 if(totalScore < 0)
			 {
				 	request.setAttribute("error", "Score can not be less than 0");
					RequestDispatcher rd;
					rd= request.getRequestDispatcher("jsp/insertError.jsp");
					rd.forward(request,response);
				 
			 }
			 else
			 {
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					Date date = new Date();
					
					try 
					{
						date = sdf.parse(dob);
					}
					catch (ParseException e1) {
						
						request.setAttribute("error", "Format of date is not valid.");
						RequestDispatcher rd;
						rd= request.getRequestDispatcher("jsp/insertError.jsp");
						rd.forward(request,response);
					}
					
					cricketScoredto = new CricketScoreDTO();
					
					cricketScoredto.setPlayerName(playerName);
					cricketScoredto.setDob(date);
					cricketScoredto.setTeam(team);
					cricketScoredto.setBattingstyle(battingstyle);
					cricketScoredto.setCenturies(centuries);
					cricketScoredto.setMatchesplayed(matchesplayed);
					cricketScoredto.setTotalScore(totalScore);
					
					cricketServiceImpl = new CricketServiceImpl();
					
					try 
					{
						result = cricketServiceImpl.insertData(cricketScoredto);

						if(result == 1)
						{
							RequestDispatcher rd;
							rd= request.getRequestDispatcher("jsp/insertSuccess.jsp");
							rd.forward(request,response);
						}
						
					} 
					catch (CricketScoreException e) {
						
						request.setAttribute("error", e.getMessage());
						RequestDispatcher rd;
						rd= request.getRequestDispatcher("jsp/insertError.jsp");
						rd.forward(request,response);

					}
					
			 }
			 
			
				
				
				
				
				
				
		}
		
		
		
		
	}

}
