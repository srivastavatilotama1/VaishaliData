package com.igatepatni.jms;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("messageProducer")
public class JMSMessageProducer {

    public JMSMessageProducer() 
    {
		super();
		System.out.println("in producer constructor");
	}

	private static final Logger logger = LoggerFactory.getLogger(JMSMessageProducer.class);

    @Autowired
    private JmsTemplate template = null;
    private int messageCount = 5;
    static String MESSAGE_COUNT="Message_Count";
    
    
    @PostConstruct
    public void sendMessages() throws JMSException 
    {
    	System.out.println("in sendMessages()");
        for (int i = 0; i < messageCount; i++) 
        {
            final int index = i;
            final String text = "Message number is " + i + ".";

            template.send(new MessageCreator() 
            {
                public Message createMessage(Session session) throws JMSException 
                {
                    TextMessage message = session.createTextMessage(text);
                    message.setIntProperty(MESSAGE_COUNT, index);
                    System.out.println("Sending message: " + text);
                    //System.out.println("message: " + message);
                    logger.info("Sending message: " + text);
                    
                    return message;
                }
            });
        }
    }

}