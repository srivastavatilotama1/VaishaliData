package com.cg.frs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class DataValidator {

	public boolean validateData(String pattern,String str)
			throws FlatException
			{
					try {
						Pattern pat= Pattern.compile(pattern);
						Matcher m= pat.matcher(str);
						boolean result= m.find();
						return result;
					} catch (PatternSyntaxException e) {
						throw new FlatException(e.getMessage());
					}
			}
					
					public boolean MobileNo(long MobileNo)
					{
						if (MobileNo >700000000)
							return true;
						else 
							return false;
					}
					public boolean rentAmt(double rentAmt)
					{
						if (rentAmt>5000)
							return true;
						else 
							return false;
					}
				/*	public boolean depositAmt(double depositAmt)
					{
						if (depositAmt>20000)
							return true;
						else 
							return false;
					}*/
					public boolean depositAmt(double depositAmt,double rentAmt)
					{
						//double rentAmt = 7000;
						if (depositAmt>rentAmt)
							return true;
						else 
							return false;
					}
					public boolean FlatType(int FlatType)
					{
						if (FlatType>0)
							return true;
						else 
							return false;
					}
}
