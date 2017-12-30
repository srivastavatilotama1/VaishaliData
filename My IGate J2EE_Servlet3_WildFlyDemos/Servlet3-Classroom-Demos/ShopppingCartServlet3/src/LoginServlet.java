import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet 
{
	Connection con;
	Statement st;
	ResultSet rs=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig cofig) throws ServletException
    {
    
    	
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			st=con.createStatement();
			
			System.out.println("Servlet Init Method..................................................."+con  +"     "+rs);
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Servlet DoGet Method................................"+con+"     "+rs);
		PrintWriter pw=response.getWriter();
		HttpSession ses=null;
		try 
		{
			rs=st.executeQuery("select * from UserTable");
		} catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String name=request.getParameter("usr");
		String pwd=request.getParameter("pwd");
			
		
		HttpSession logSes=request.getSession();
		System.out.println("Login Session ....is new .........." +logSes+"   "+logSes.isNew());
		if(!logSes.isNew())
		{
			
			logSes.invalidate();
			System.out.println(" Old session Invalidated......................");
			//If session is inlidated then getSession(false) return null;
			logSes=request.getSession(true);
			System.out.println(" After invalidation............"+logSes);
			
		}
		boolean flag=false;
		try 
		{
			boolean rsflag=rs.next();
			System.out.println("Resultset flag............"+rsflag);
			while(rsflag)
			{
				String s1=rs.getString(1);
				String s2=rs.getString(2);
				System.out.println( "ResultSet  User :"+s1+"Password :"+s2);
				System.out.println();
				if((name.equals(s1))&&(pwd.equals(s2)))
				{
					System.out.println("true block............................................");
					flag=true;
					break;
				}
				rsflag=rs.next();
					
			}
			if(flag==true)
			{
				pw.println(" Welcome U R A Valid User "+name);
				logSes.setAttribute("USERSESS", name);
				
				pw.println("</br> session  id in login" +	" "+logSes.getId()) ;
				pw.println("<a href='/JspBeanP/CatalogServlet'>Go To catalog</a>");
				
			}
			else
			{
				pw.println(" In Valid User "+name);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
