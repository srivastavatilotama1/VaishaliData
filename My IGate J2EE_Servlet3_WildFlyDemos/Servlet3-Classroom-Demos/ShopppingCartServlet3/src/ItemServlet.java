

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ItemServlet
 */
public class ItemServlet extends HttpServlet
{
	ArrayList cartList;HttpSession ses;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter(); 
		
		 ses=request.getSession(true);
		 String user=(String)ses.getAttribute("USERSESS");
		 cartList=(ArrayList) ses.getAttribute("Cart");
		String str=request.getParameter("books");
		if(cartList==null)
		{
			cartList=new ArrayList();
			cartList.add(str);
		}
		else
		{
			cartList.add(str);
			ses.setAttribute("Cart", cartList);
		}
		
		
		ses.setAttribute("Cart", cartList);
		out.println("</br>U  R Item List " +	" "+user) ;
		out.println("</br> session " +	" "+ses.getId()) ;
		out.println("</br> session  Ref" +	" "+ses) ;

		
		out.println("</br> Added  Items in the list " +	" "+(ArrayList)ses.getAttribute("Cart")) ;
		
		out.println("</br><a href='/JspBeanP/CatalogServlet'>Go Back To Select Item Again</a>");
		out.println("</br><a href='/JspBeanP/logout.jsp'>Logout</a>");
	}

}
