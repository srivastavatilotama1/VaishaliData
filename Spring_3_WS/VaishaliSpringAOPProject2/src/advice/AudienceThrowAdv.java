package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import bean.Audience;

@Aspect
public class AudienceThrowAdv 
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
		@AfterThrowing(pointcut="execution(* bean.Performer.perform(..))" , 
				throwing= "error") 
  public void doAfterThrowing(JoinPoint joinPoint,Throwable error) 
	 { 
	        System.out.println("***AspectJ*** DoBefore() is running!!" +
	        		" intercepted : " + joinPoint.getSignature().getName()); 
	        audience.takeSeates();
	        audience.turnOffCellPhone();
	    } 
}

		 