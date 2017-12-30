package advice;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import bean.Audience;

public class AudienceBeforeAdvice implements MethodBeforeAdvice
{
	 // injected
	  private Audience audience;
	  public void setAudience(Audience audience) 
	  {
	    this.audience = audience;
	  }
	  public AudienceBeforeAdvice() {}
	    
	  public void before(Method method, Object[] args, Object target)    throws Throwable
	  {
	    audience.takeSeates();
	    audience.turnOffCellPhone();
	  }
	

}
