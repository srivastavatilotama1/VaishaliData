import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.igate.bean.MobileBean;
import com.igate.bean.PurchaseDetailsBean;
import com.igate.dao.PurchaseDetailsDAO;
import com.igate.dao.PurchaseDetailsDAOImpl;
import com.igate.dto.PurchaseDetailsDTO;
import com.igate.exception.InvalidDataException;
import com.igate.service.MobileService;
import com.igate.service.PurchaseDetailsService;


public class TestMobilePurchaseDemo 
{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args)
	{		
		int choice;		
		while(true)
	
		{
			System.out.println("What Do U Want To Do?");
			System.out.println("\t\t\t 1: INSERT CUSTOMER  & Purchase  DEATAILS");
			System.out.println("\t\t\t 2: View MOBILEs DEATAILS ");
			System.out.println("\t\t\t 3: Delete MOBILE DEATAILS ");
			System.out.println("\t\t\t 4: SEARCH MOBILE USING RANGE");
			System.out.println("\t\t\t 0: EXIT");
			System.out.print(" Please Enter Your Choice: ");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:enterCustomerDetails();
						break;	
				default:System.exit(0);			
			}				
		}
	}
	private static void  enterCustomerDetails()

	{
		String  emailId;
		String  custName;
		long  phoneNo;
		int purchaseId;
		int mobileId;
		int quantity;
		boolean testCustFlag = true;
		boolean testEmailFlag = true;
		boolean testPhoneFlag = true;
		boolean testMobileIdFlag=true;
		boolean testQtyFlag=true;
		
		Scanner sc = new Scanner(System.in);
		
		//System.out.print("\t\tEnter Purchase Id:");
		//purchaseId=sc.nextInt();
	
		while (testCustFlag)
		{
			System.out.print("\t\t Enter custName :");
			custName = sc.next();			
			
			System.out.print("\t\t Enter Email Address :");
			emailId = sc.next();
					
			System.out.print("\t\t Enter Phone No :");
			phoneNo = sc.nextLong();
							
			System.out.print("\t\tEnter Mobile Id :");
		    mobileId = sc.nextInt();
		    
		    System.out.print("\t\tEnter Qty:");
		    quantity = sc.nextInt();
			   
		    PurchaseDetailsDTO purchaseDetailsDto=new PurchaseDetailsDTO();
			 
		    purchaseDetailsDto.setCustName(custName);
		    purchaseDetailsDto.setMailId(emailId);
		    purchaseDetailsDto.setPhoneNo(phoneNo);			  
		    purchaseDetailsDto.setMobileId(mobileId);
		    purchaseDetailsDto.setQty(quantity);
		    
		    PurchaseDetailsService purchaseDetailsService=
		    	new PurchaseDetailsService();
		    
		    try 
		    {
				purchaseDetailsService.addPurchaseDetails(purchaseDetailsDto);
			} 
		    catch (InvalidDataException e)
		    {				
			System.out.println("Some data error");
			//	e.printStackTrace());
			}
		    
								
		}	
		
	
	}

}
