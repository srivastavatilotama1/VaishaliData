package advice;
import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import bean.Audience;
public class AudienceAfterAdvice  implements AfterReturningAdvice
{
	 private Audience audience;
	public  AudienceAfterAdvice()
	 {
		 
	 }
	
	public void setAudience(Audience audience) 
	{
		this.audience = audience;
	}


	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable
			{
		audience.appLaud();
		
	}

}
