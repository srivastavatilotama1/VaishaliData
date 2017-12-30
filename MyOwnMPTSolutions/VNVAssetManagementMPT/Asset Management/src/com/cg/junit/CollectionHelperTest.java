/*******Author Name: Christy JV Emp Id : 101484 Date: 20.5.2017 ******/
//Purpose: To provide test cases of Asset Management

package com.cg.junit;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.bean.AllocationDetails;
import com.cg.exception.AssetException;
import com.cg.helper.CollectionHelper;

@SuppressWarnings("deprecation")
public class CollectionHelperTest
{
	static CollectionHelper collectionHelper;
	static AllocationDetails all=null;

	//adding asset details to the array list
	@BeforeClass
	public   static  void beforeClass()
	{
		collectionHelper=new CollectionHelper();
		all=new AllocationDetails("Mouse","Permanent","123456",java.time.LocalDate.now(),888088);		
	}
	
	//clearing the arraylist
	@AfterClass
	public static  void afterClass()
	{		
		collectionHelper=null;
		all=null;
	}	
	
	//checking whether asset details are present in array list
	@Test 
	public void testAddNewCustomer() throws AssetException
	{
		collectionHelper.addNewAsset(all);
		Assert.assertNotNull(all.getAllocationId());
	}

}
