package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;

import bean.Audience;

@Aspect
public class AudienceAfterAdv 
{
	 private Audience audience;;
	 
	public Audience getAudience() 
	{
		return audience;
	}

	public void setAudience(Audience audience) 
	{
		this.audience = audience;
	}

	@After("execution(* bean.Instrumentalist.perform(..))")
	      public void doAfter(JoinPoint joinPoint) 
		 {           System.out.println("***AspectJ*** DoAfter() is running!! intercepted : " +
		            		 joinPoint.getSignature().getName()); 
		 audience.appLaud();			
 
		 } 

}
