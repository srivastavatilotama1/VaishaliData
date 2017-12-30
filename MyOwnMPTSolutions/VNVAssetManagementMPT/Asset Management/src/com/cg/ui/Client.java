/*******Author Name: Christy JV Emp Id : 101484 Date: 20.5.2017 ******/
//Purpose: To provide user interface of Asset Management for accepting & displaying asset details

package com.cg.ui;

import java.util.Random;
import java.util.Scanner;

import com.cg.bean.AllocationDetails;
import com.cg.exception.AssetException;
import com.cg.helper.CollectionHelper;
import com.cg.helper.DataValidator;

public class Client 
{
	static Scanner sc=new Scanner(System.in);
	static CollectionHelper collectionhelper=null;
	
	//Main method
	public static void main(String[] args)
	{
		String choice;
		collectionhelper=new CollectionHelper();

		while(true)
		{
			//Providing user interface
			System.out.println("Asset Management \n***************** \n1. Insert Asset allocation details\n"
					+ "2. Exit From System");
			
			System.out.println("\nEnter your choice :");
			choice=sc.next();
			switch(choice)
			{
			
			//Calling enterAllocationDetails method for getting & displaying asset details 
			case "1":enterAllocationDetails();break;
			case "2":System.exit(0);
			default: System.out.println("Please enter correct choice");
			break;
			}
		}
	}
	
	//method for getting & displaying asset details
	private static void enterAllocationDetails() 
	{
		System.out.println("Enter Asset Name:");
		String assetName=sc.next();
		try 
		{
			//sending input to validateAssetName method for validating allocation type
			if(DataValidator.validateAssetName(assetName))
			{
				System.out.println("Enter Allocation Type ");
				String allocationType=sc.next();
				//sending input to validateAccount method for validating asset name
				if(DataValidator.validateAccount(allocationType))
				{
					System.out.println("Enter Employee Number ");
					String empId=sc.next();
					
					//sending input to validateEmployeeNumber method for validating employee number
					if(DataValidator.validateEmployeeNumber(empId))
					{
						//Generate  Random Allocation Id
						Random ran=new Random();
						long allocationId=ran.nextInt();
						//sending valid input data to the constructor of AllocationDetails class
						AllocationDetails cc=new AllocationDetails(assetName, 
								allocationType, empId,java.time.LocalDate.now(), 
								allocationId);
						//adding valid input data of asset details to the array list
						collectionhelper.addNewAsset(cc);
						//displaying all the existing asset details of the arrary list
						collectionhelper.displayAllAssets();
					}
					}	
				}
						
		} 
		catch (AssetException e)
		{			
			System.out.println(e.getMessage());
		}		

	}
}
