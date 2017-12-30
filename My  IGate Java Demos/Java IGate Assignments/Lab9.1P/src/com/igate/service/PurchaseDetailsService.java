package com.igate.service;

import java.util.Collection;
import java.util.regex.Pattern;

import com.igate.dao.MobileDAO;
import com.igate.dao.MobileDAOImpl;
import com.igate.dao.PurchaseDetailsDAO;
import com.igate.dao.PurchaseDetailsDAOImpl;
import com.igate.dto.PurchaseDetailsDTO;
import com.igate.exception.InvalidDataException;


public class PurchaseDetailsService 
{
	public void addPurchaseDetails(PurchaseDetailsDTO purchaseDetailsDto)throws InvalidDataException
	{
		
		boolean custFlag = validateName(purchaseDetailsDto.getCustName());
		if (custFlag == true)
		{
			boolean emailFlag = validateEmail(purchaseDetailsDto.getMailId());
				if (emailFlag == true)
				{								
						boolean phoneFlag = validatePhone(purchaseDetailsDto.getPhoneNo());
						if (phoneFlag == true) 
						{
							boolean mobileFlag = validateMobileId(purchaseDetailsDto.getMobileId());
								if (mobileFlag == true) 
								{									
										boolean qtyFlag = validateQty(purchaseDetailsDto.getQty(),purchaseDetailsDto.getMobileId());
										if (qtyFlag == true) 
										{											
											PurchaseDetailsDAO pddao=new PurchaseDetailsDAOImpl();
											MobileDAO mobileDao=new MobileDAOImpl();
											
											pddao.addPurchaseDetails(purchaseDetailsDto);											
											mobileDao.updateMobileByQty(purchaseDetailsDto.getQty(),
													purchaseDetailsDto.getMobileId());
											//break;//break Qty loop										
										}
								}
								//break;// Mobile  loop	
						}
						//break;//break Phone loop	
				}					
				//break;//break email loop								
		}
		//break ;//break customerfalg  loop
	}		
	
/*	public void deletePurchaseDetails()
	{
		
	}
	public  Collection<PurchaseDetailsDTO>  getPurchaseDetails()
	{
		
	}
	public MobileDTO getPurchaseDetailsById()
	{
		
	}
	public void updatePurchaseDetails()
	{
	}*/
	
	

	private static boolean validatePhone(long phoneNo)
	{
		String phonepattern="[\\d]{10}";
		String no=new Long(phoneNo).toString();
		if(Pattern.matches(phonepattern, no))
		{
			return true;				
		}
		else
		{
			System.out.println(" Phone No maximum  10 digits");
			return false;
		}		
	}
	private static boolean validateEmail(String emailId) 
	{		
		String emailNamePtrn = 
			"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 		 
		if(Pattern.matches(emailNamePtrn, emailId))
		{
			return true;				
		}
		else
		{
			System.out.println(" Give a valid email address");
			return false;
		}	

	}
	private static boolean validateName(String custName) 
	{
		//First Cap max 20;
		String pattern="[A-Z][a-z]{0,19}";
		if(Pattern.matches(pattern, custName))
		{
			return true;				
		}
		else
		{
			System.out.println(" Customer name should start with capital and max length is 20");
			return false;
		}		
	}
	
	
	private static boolean validateMobileId(int mobileId) throws InvalidDataException 
	{
		
		String pattern="[0-9]{4}";
		String mId=new Integer(mobileId).toString();
		if(Pattern.matches(pattern,mId ))
		{
			MobileService ms=new MobileService();
			Collection<Integer> midLi=ms.getMobileIds();
			if(midLi.contains(mobileId))
			{				
				return true;
			}
			else
			{	
				System.out.println(" Mobile Id do not exist It should be from following  values");
				for(int ii:midLi)
				{
					System.out.print ("  "+ii);
				}
				return false;	
			}
		}
		else
		{
			System.out.println(" Mobile Id Should be  only 4 digits");
			return false;
		}		
	}
	
	public static boolean  validateQty(int purchaseQty,int mobileId) throws InvalidDataException
	{
		MobileService mobileService=new MobileService();
		int qtyInHand=mobileService.getMobileQty(mobileId);
		System.out.println("*****************"+qtyInHand);
		
		
		if((purchaseQty>0)&&(purchaseQty<qtyInHand))
		{
			return true;
		}
		else
		{
			System.out.println(" UR Quantity shouls be greater than zero ");
			System.out.println(" In hand Quantity is : "+qtyInHand);
			return false;
		}
		
		
	
	}

}
