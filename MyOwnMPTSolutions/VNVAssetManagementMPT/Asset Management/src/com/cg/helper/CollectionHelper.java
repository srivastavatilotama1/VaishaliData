/*******Author Name: Christy JV Emp Id : 101484 Date: 20.5.2017 ******/
//Purpose: To create arraylist for adding & displaying asset details

package com.cg.helper;
import java.util.ArrayList;
import java.util.Iterator;
import com.cg.bean.AllocationDetails;


public class CollectionHelper
{
	//creating array list and adding default data
	private  static ArrayList<AllocationDetails> allocationList=null;
	static
	{
		allocationList=new ArrayList<AllocationDetails>();
		AllocationDetails a1=new AllocationDetails("Mouse","Permanent","123456",java.time.LocalDate.now(),888088);
		AllocationDetails a2=new AllocationDetails("Keyboard","Temproary","876543",java.time.LocalDate.now(),9656544);
		
		allocationList.add(a1);
		allocationList.add(a2);
	}
	
	public CollectionHelper(){}
	
	//adding asset details to the array list
	public void addNewAsset(AllocationDetails asset) 
	{			
			allocationList.add(asset);				
	}
	
	public static ArrayList<AllocationDetails> getAssetList() {
		return allocationList;
	}

	public static void setAssetList(ArrayList<AllocationDetails> allocationList) {
		CollectionHelper.allocationList = allocationList;
	}

	//displaying all asset details
	public  void displayAllAssets()
	{
		Iterator<AllocationDetails> assetIt=allocationList.iterator();
		AllocationDetails tempAsset=null;
		while(assetIt.hasNext())
		{
			tempAsset=assetIt.next();
			System.out.println(tempAsset);			
		}
	}
	
}
