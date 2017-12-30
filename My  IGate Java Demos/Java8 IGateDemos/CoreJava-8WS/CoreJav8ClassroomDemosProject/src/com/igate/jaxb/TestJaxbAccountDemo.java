package com.igate.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class TestJaxbAccountDemo 
{
	public static void main(String[] args) throws Exception
	{		
		
	/* JAXBContext jc = JAXBContext.newInstance(Account.class);    
		 Account acc = new Account();   
		 acc.setAno("101");
		 acc.setAccType("Saving");
		 acc.name = "Vaishali ";     
		 Marshaller marshaller = jc.createMarshaller();    
		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
		 marshaller.marshal(acc, System.out); */
		
		
		JAXBContext jc = JAXBContext.newInstance(Emp.class);    
		 Emp ee = new Emp();   
		 ee.setEmpNo("888");
		 ee.ename = "Vaishali ";     
		 Marshaller marshaller = jc.createMarshaller();    
		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
		 marshaller.marshal(ee, System.out); 

		
	
		
	}

}
