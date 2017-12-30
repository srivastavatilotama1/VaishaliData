package advice;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import bean.Audience;
@Aspect
public class AudienceBeforeAdv
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
		
		@Before  ("execution(* bean.Instrumentalist.perform(..))")
	      public void doBefore(JoinPoint joinPoint) 
		 {           System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " +
		            		 joinPoint.getSignature().getName()); 
		 audience.takeSeates();		
		 audience.turnOffCellPhone();

		 } 
}
