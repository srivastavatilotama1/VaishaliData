package com.igatepatni.scheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.oxm.castor.CastorMarshaller;

public class TaskExecutorExample
{
	private class MessagePrinterTask implements Runnable
	{
		private String message;

		public MessagePrinterTask(String message)
		{
			this.message = message;
		}

		public void run() 
		{
			System.out.println("Run........."+message);
		}
	}
	private TaskExecutor taskExecutor;

	public TaskExecutorExample(TaskExecutor taskExecutor) 
	{
		this.taskExecutor = taskExecutor;
	}

	public void printMessages() 
	{
		for (int i = 0; i < 5; i++) 
		{
			taskExecutor.execute(new MessagePrinterTask("Message............" + i));
		}
	}	
	public static void main(String args[])
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-scheduler.xml");
		TaskExecutorExample tee = (TaskExecutorExample)context.getBean("taskExecutorExample");
		tee.printMessages();		
	}
}