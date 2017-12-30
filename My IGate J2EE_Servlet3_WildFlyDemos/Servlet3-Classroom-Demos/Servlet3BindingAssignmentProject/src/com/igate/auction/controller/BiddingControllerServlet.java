package com.igate.auction.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.igate.auction.dao.UserDaoImpl;
import com.igate.auction.dto.ItemsForBid;
import com.igate.auction.dto.LoginDTO;
import com.igate.auction.service.IItemsForBidService;
import com.igate.auction.service.ItemsForBidServiceImpl;
@WebServlet("/BiddingControllerServlet")
public class BiddingControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	ServletConfig config;
	public BiddingControllerServlet()
	{
		super();        
	}
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		super.init(config);
		System.out.println("In Init method of BiddingControllerServlet Controller");
	}
	public void destroy()
	{
		System.out.println("In Destroy method of BiddingControllerServlet  Controller");
	}

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException 
	{
		doPost(request,response);
		
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();		
		String action=request.getParameter("action");
		IItemsForBidService itemBidService=new ItemsForBidServiceImpl();
	//*****************************************
		if(action!=null)
		{
			//****************1 action*****************
			if(action.equals("showMyBidItems"))
			{				
				HttpSession session=request.getSession();
				System.out.println("In BiddingControllerServlet   showMyBidItems()..................... ");
				String itemBidId=(String)request.getParameter("bidItemId");
				System.out.println(" Item Bid in BiddingControllerServlet   showMyBidItems"+itemBidId);
				
				ArrayList<ItemsForBid> myBidItemList=(ArrayList)session.getAttribute("MyBidItemList");
				ItemsForBid myItemForBid=itemBidService.getItemForBidById(Integer.parseInt(itemBidId));
				System.out.println(" For "+
						itemBidId+ "  in BiddingControllerServlet showMyBidItems   Info is "+myItemForBid);
				if(myBidItemList!=null)
				{
					System.out.println("myBidItemList   in showMyBidItems  not  null....in bidcontroller servlet");
					if(!myBidItemList.contains(myItemForBid))
					{
						System.out.println("myBidItemList   contains : "+myItemForBid.getItemId());
						myBidItemList.add(myItemForBid);						
					}								
				}
				else
				{
					System.out.println("myBidItemList   is null....in BiddingControllerServlet servlet showMyBidItems ");
					myBidItemList=new ArrayList<ItemsForBid>();
					myBidItemList.add(myItemForBid);					
				}
				session.setAttribute("MyBidItemList", myBidItemList);
				RequestDispatcher rd=
					request.getRequestDispatcher
					("ShowMyBidItemsServlet");
				rd.forward(request, response);				
			}	
			//***************************************		
			
			if(action.equals("removeMyBidItems"))
			{				
				HttpSession session=request.getSession();
				System.out.println("In BiddingControllerServlet  removeMyBidItems" );
				String itemBidId=(String)request.getParameter("bidItemId");
				System.out.println(" Item Bid   BiddingControllerServlet   removeMyBidItems "+itemBidId);
				
				ArrayList<ItemsForBid> myBidItemList=(ArrayList)session.getAttribute("MyBidItemList");
				ItemsForBid myItemForBid=itemBidService.getItemForBidById(Integer.parseInt(itemBidId));
				System.out.println(" For "+
						itemBidId+ "  in BiddingControllerServlet removeMyBidItems  Info is "+myItemForBid);
				if(myBidItemList!=null)
				{
					System.out.println("in removeMyBidItems myBidItemList   is not  null....in bidcontroller servlet");
					if(myBidItemList.contains(myItemForBid))
					{
						System.out.println(" removeMyBidItems myBidItemList   contains : "+myItemForBid.getItemId());
						myBidItemList.remove(myItemForBid)	;	
						System.out.println(" after removing items.................... "+myBidItemList);
						session.setAttribute("MyBidItemList", myBidItemList);
					}								
				}
				else
				{
					System.out.println("myBidItemList   is null....in BiddingControllerServlet servlet");
					myBidItemList=new ArrayList<ItemsForBid>();
					myBidItemList.add(myItemForBid);					
				}
				session.setAttribute("MyBidItemList", myBidItemList);
				RequestDispatcher rd=
					request.getRequestDispatcher
					("ShowMyBidItemsServlet");
					//("BiddingControllerServlet?action=showMyBidItems");
				rd.forward(request, response);				
			}	
			//*********************************************
			if(action.equals("displayFinalCostServlet"))
			{				
				HttpSession session=request.getSession();
				ArrayList<ItemsForBid> myBidItemList=(ArrayList)session.getAttribute("MyBidItemList");
				
				System.out.println("In BiddingControllerServlet  displayFinalCostServlet..........."+
				myBidItemList );
				
				float finalCost=0.0f;
				Iterator<ItemsForBid>  myBidItemListIt=myBidItemList.iterator();
				int finalUpdateCount=0;
				while(myBidItemListIt.hasNext())
				{
					ItemsForBid tempItemsForBid=myBidItemListIt.next();
					finalCost=finalCost+tempItemsForBid.getItemPrice();	
					finalUpdateCount=finalUpdateCount+itemBidService.updateItemStatus(tempItemsForBid.getItemId());
				}
				
				session.setAttribute("FinalCost", finalCost);
				
				System.out.println(" No Of Rec updated ........."+finalUpdateCount);
				
				RequestDispatcher rd=
						config.getServletContext().getRequestDispatcher
					("/DisplayFinalCostServlet");					
				rd.forward(request, response);				
			}	
		}		
		//************************************************
		else
		{
			out.println(" No Action........");
		}
		
	}


}
