package com.igate.service;

import java.util.Collection;

import com.igate.dao.MobileDAO;
import com.igate.dao.MobileDAOImpl;
import com.igate.exception.InvalidDataException;


public class MobileService
{
//	public void addMobile();
	//public void deleteMobile(int mobileId);
	//public  Collection<MobileDTO>  getMobiles();
	//public MobileDTO getMobileByPriceRange(int lowRange,int highRange);
	public int getMobileQty(int mobileId) throws InvalidDataException
	{
		MobileDAO md=new MobileDAOImpl();
		return 	md.getMobileQty(mobileId);
		
	}
	
	public void updateMobileByQty(int qty,int mobileId)throws InvalidDataException
	{
		MobileDAO md=new MobileDAOImpl();
		md.updateMobileByQty(qty, mobileId);
		
	}
	
//	public int getMobileQty(int mobileId);
	public Collection<Integer> getMobileIds() throws InvalidDataException
	{
		MobileDAO md=new MobileDAOImpl();		
		return md.getMobileIds();		
	}
}
