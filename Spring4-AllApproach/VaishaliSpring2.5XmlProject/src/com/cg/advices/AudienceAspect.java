package com.cg.advices;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.cg.aop.bean.Audience;
public class AudienceAspect 
{
	private Audience audience;
	public void setAudience(Audience audience) 
	{
		this.audience = audience;
	}
	public AudienceAspect() {}
	
	public void performBefore()
	{
		audience.takeSeates();
		audience.turnOffCellPhone();
		//System.out.println("************ : " + joinPoint.getSignature().getName());
	}
	public void performAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("performAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("performAround before proceed is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("performAround after  proceedis running!");

		System.out.println("******");	 
	}
	public void performAfterThrowing(JoinPoint jp,Throwable error) {
	
		System.out.println("Bool We want our  moany back");	
		System.out.println("******");

	}

	public void performAfter()
	{
		audience.appLaud();
		//System.out.println("************* : " + joinPoint.getSignature().getName());
	}
}