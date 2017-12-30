package com.igate.aop;

import java.sql.Connection;
import java.sql.DriverManager;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DaoProfiler {
	
	
	@Pointcut("execution(* com.igate.aop.*.*(..))")
    public void businessMethods() { }

    @Around("businessMethods()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
    	
    	   Connection con=null;
    	   Object obj = pjp.getTarget(); 
    	    try
    	    {
    	      Class.forName("com.mysql.jdbc.Driver");
    	      String url="jdbc:mysql://localhost:3306/mona";
    	      con=DriverManager.getConnection(url,"root","mohan");
    	     
    	      if(obj instanceof ConnectionAware)
    	      {
    	    	  ((ConnectionAware)obj).setConnection(con);
    	      }
    	        
    	    }
    	    catch(Exception e)
    	    {
    	    	e.printStackTrace();
    	    }
    	    
    	    System.out.println("Going to call the method.");
    	    Object output=pjp.proceed();
    	    
            if(obj instanceof ConnectionAware)
  	        {
  	    	  ((ConnectionAware)obj).removeConnection();
  	        }		
            
            return output;
    }
    

}
