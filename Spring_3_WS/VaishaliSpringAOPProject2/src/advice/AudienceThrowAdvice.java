package advice;


import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import bean.Audience;

public class AudienceThrowAdvice implements  ThrowsAdvice
    {
	 // injected
	  private Audience audience;
	  public void setAudience(Audience audience) 
	  {
	    this.audience = audience;
	  }
  public AudienceThrowAdvice() {}
  
  
  public void afterThrowing(Throwable throwable)
  {
    audience.demandRefund();
  }
  
  public void afterThrowing(Method method, Object[] args, Object target,Throwable throwable) 
  {
    audience.demandRefund();
  }
  
 
}