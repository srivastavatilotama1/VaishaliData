package com.cg.frs;

import junit.framework.Assert;
import org.junit.Test;


public class FlatTest {
	@Test
	public void GetfirstName(){
	
		Flat a1= new Flat("Vinod","Satpute",81495125,1,7000.0,25000.0);
		String fn= a1.getFirstName();
		Assert.assertEquals("Vinod", fn);
	}
	@Test
	public void GetlastName(){
	
		Flat a1= new Flat("Vinod","Satpute",81495125,1,7000.0,25000.0);
		String fn= a1.getLastName();
		Assert.assertEquals("Satpute", fn);
	}
	@Test
	public void GetMobileNumber(){
	
		Flat a1= new Flat("Vinod","Satpute",81495125,1,7000.0,25000.0);
		long fn= a1.getMobileNo();
		Assert.assertEquals(81495125, fn);
	}
	
	@Test
	public void GetFlatType(){
	
		Flat a1= new Flat("Vinod","Satpute",81495125,1,7000.0,25000.0);
		long fn= a1.getFlatType();
		Assert.assertEquals(1, fn);
	}
	@Test
	public void GetrentAmt(){
	
		Flat a1= new Flat("Vinod","Satpute",81495125,1,7000.0,25000.0);
		double fn= a1.getRentAmt();
		Assert.assertEquals(7000.0, fn);
	}
	@Test
	public void GetdeposittAmt(){
	
		Flat a1= new Flat("Vinod","Satpute",81495125,1,7000.0,25000.0);
		double fn= a1.getDepositAmt();
		Assert.assertEquals(25000.0, fn);
	}
	
	
	@Test(expected=Exception.class)
	public void TestException() throws FlatException {
		DataValidator validator= new DataValidator();
		validator.validateData("[A-Za]{[2,10}", "Apple");
	}
	@Test(expected=NullPointerException.class)
	public void testINsertMethod()throws FlatException{
		
		Flat acc= null;
		DBHelper db= new DBHelper();
		db.insertFlat(acc);
	}
	
	@Test
	public void testInsertMethod(){
		try {
			Flat acc= new Flat("Vinod","Satpute",81495125,1,7000,25000);
			DBHelper db= new DBHelper();
			long FlatId= db.insertFlat(acc);
			Assert.assertEquals(1006,FlatId);
		} catch (FlatException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
