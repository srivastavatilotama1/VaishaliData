package com.cg.advices;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class AudienceAspects
{
//method will be executed before the execution
	@Before("execution(* com.cg.aop.bean.Performer.perform())")
	public void performBefore(JoinPoint joinPoint) {

		System.out.println("performBefore() is running!");
		System.out.println("Audience is taking their seates.");
		System.out.println("Audience is turnning of  their cell phones.");
		System.out.println("************ : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
	//method will be executed after the execution of 
	@After("execution(* com.cg.aop.bean.Performer.perform())")
	public void performAfter(JoinPoint joinPoint) {

		System.out.println("performAfter() is running!");
		System.out.println("Clap Clap Clap Clap");
		System.out.println("************* : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	//method will be executed if the customerBo interface, 
	//addCustomerThrowException() method is throwing an exception.
	@AfterThrowing(
			pointcut = "execution(* com.cg.aop.bean.Performer.perform())",
			throwing= "error")
	public void performAfterThrowing(JoinPoint joinPoint, 
			Throwable error) {

		System.out.println("performAfterThrowing() is running!");
		System.out.println("Bool We want our  moany back");
		System.out.println("********** : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");

	}
	
	//*********************************8
	@Around("execution(* com.cg.aop.bean.Performer.perform())")
	   public void performAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("performAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("performAround before is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("performAround after is running!");

		System.out.println("******");	 
	}
}


