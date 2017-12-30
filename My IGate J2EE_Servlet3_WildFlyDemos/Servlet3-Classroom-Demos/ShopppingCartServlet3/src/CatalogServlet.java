

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CatalogServlet
 */
public class CatalogServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServlet() 
    {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter pw=response.getWriter();
		HttpSession catSess=request.getSession(true);
		pw.println("<html><body><h2>Welcome......"+(String)catSess.getAttribute("USERSESS"));
		pw.println("</br>Is New sessionin Catlog " +	" "+catSess.isNew()) ;
		pw.println("</br> session  Id in Catalog" +	" "+catSess.getId()) ;
		pw.println("<form  name='form1'  action='/JspBeanP/ItemServlet'>");
		pw.println("<br>Books Category:	<select  name='books'  size='1'>");
		pw.println("<option>C</option><option>C++</option><option>Java</option>");
		pw.println("<option>DotNet</option><option>Html</option><option>JavaScript</option>");
		pw.println("<option>OS</option><option>Network</option><option>Compiler</option>");
		pw.println("</select>");
		pw.println("<input type='submit' name='click' value='Add To Cart'>");
		pw.println("</form>");
		pw.println("</body></html>");
	}

}
