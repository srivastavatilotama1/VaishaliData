package com.igate.dao;
import java.util.ArrayList;
import java.util.Collection;

import com.igate.dto.MobileDTO;
import com.igate.dto.PurchaseDetailsDTO;
import com.igate.exception.InvalidDataException;



public interface PurchaseDetailsDAO 
{
	public void addPurchaseDetails(PurchaseDetailsDTO purchaseDetailsDto)throws InvalidDataException;
	public void deletePurchaseDetails();
	public  ArrayList<PurchaseDetailsDTO>  getPurchaseDetails();
	public MobileDTO getPurchaseDetailsById();
	public void updatePurchaseDetails();
}
