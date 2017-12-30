package com.igatepatni.jms;

import javax.jms.JMSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class drives the example from the producer side. It loads the Spring
 * {@link ApplicationContext} and sends messages. The entire configuration for
 * this app is held in <tt>src/main/resources/jms-context.xml</tt>.
 */
public class RunMsgProducer 
{

	private static final Logger logger = LoggerFactory
			.getLogger(RunMsgProducer.class);

	public static void main(String[] args) throws JMSException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"message-context.xml", RunMsgProducer.class);
		JMSMessageProducer producer = (JMSMessageProducer) context
				.getBean("messageProducer");
		try {
			producer.sendMessages();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
