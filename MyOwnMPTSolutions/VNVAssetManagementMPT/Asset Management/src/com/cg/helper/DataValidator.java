/*******Author Name: Christy JV Emp Id : 101484 Date: 20.5.2017 ******/
//Purpose: To provide data validation for the user input

package com.cg.helper;

import java.util.regex.Pattern;

import com.cg.exception.AssetException;

public class DataValidator
{
	//validating asset name - it should be alphanumeric and minimum 3 characters
	public  static  boolean validateAssetName(String assetName)throws AssetException
	{
		String assetPattern="[A-Za-z0-9]{3,}";
		if(Pattern.matches(assetPattern, assetName))
		{
			return true;
		}
		else
		{
			throw new AssetException("Asset name should be alphanumeric and Minimum 3");
		}
	}
	
	//validating allocation type - it should be permanent or temproary	
	public  static  boolean validateAccount(String accType)throws AssetException
	{
		if(accType.equalsIgnoreCase("PERMANENT")||(accType.equalsIgnoreCase("TEMPROARY")))
		{
			return true;
		}
		else
		{
			throw new AssetException("Account Type Should Be Either Permanent OR Temproary");
		}
	}
	
	//validating employee number - it should be of number and 6 digits
	public  static  boolean validateEmployeeNumber(String empNo)throws AssetException
	{
		String employeePattern="[0-9]{6}";
		if(Pattern.matches(employeePattern, empNo))
		{
			return true;
		}
		else
		{
			throw new AssetException("Employee Number must be a numbe and only 6 Digit Allowed");
		}
	}
}
