package advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import bean.Audience;

public class AudienceAroundAdvice implements MethodInterceptor
{
	private Audience audience;
	public void setAudience(Audience audience) 
	{
		this.audience = audience;
	}
	public Object invoke(MethodInvocation invocation) throws Throwable
	{

		try
		{
			audience.takeSeates();
			audience.turnOffCellPhone();

			Object returnValue = invocation.proceed();

			audience.appLaud();

			return returnValue;
		} 
		catch (Throwable throwable) 
		{
			audience.demandRefund();

			throw throwable;
		}
	}

	// injected

}
