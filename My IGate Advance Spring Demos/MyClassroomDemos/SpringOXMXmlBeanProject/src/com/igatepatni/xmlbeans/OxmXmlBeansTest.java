package com.igatepatni.xmlbeans;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.transform.stream.StreamResult;

import org.example.message.Message;
import org.example.message.MessageType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.xmlbeans.XmlBeansMarshaller;

public class OxmXmlBeansTest {

	public static void main(String[] args) throws Exception{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("xmlbeans-context.xml");
		XmlBeansMarshaller marshaller = (XmlBeansMarshaller)context.getBean("xmlBeansMarshaller");
		
		testObjectToXml(marshaller);
	}
	
	private static void testObjectToXml(XmlBeansMarshaller marshaller) throws Exception{
		
		Message message = Message.Factory.newInstance();
		
		message.setData("Test message");
		message.setSenderId("test@test.com");
		message.setSize(12345);
		
		MessageType messageType = MessageType.Factory.newInstance();
		messageType.setValue("VIDEO");
		
		message.setMessageType(messageType);
		
		FileOutputStream outputStream = new FileOutputStream(new File("message.xml"));
		StreamResult xmlResult = new StreamResult(outputStream);
		
		marshaller.marshal(message, xmlResult);
	}	
}