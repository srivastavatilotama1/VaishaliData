package com.igatepatni.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("messageListener")
public class JMSMessageConsumer implements MessageListener {

	public JMSMessageConsumer() {
		super();
		System.out.println("in msg consumer");
	}

	private static final Logger logger = LoggerFactory
			.getLogger(JMSMessageConsumer.class);

	
	public void onMessage(Message message) {
		System.out.println("in onMessage()");
		try {
			int messageCount = message
					.getIntProperty(JMSMessageProducer.MESSAGE_COUNT);

			if (message instanceof TextMessage) {
				TextMessage tm = (TextMessage) message;
				String msg = tm.getText();
				System.out.println("Processed message : " + msg
						+ "  " + messageCount);

				logger.info("Processed message : ", msg, messageCount);
			}
		} catch (JMSException e) {
			logger.error(e.getMessage(), e);
		}
	}

}