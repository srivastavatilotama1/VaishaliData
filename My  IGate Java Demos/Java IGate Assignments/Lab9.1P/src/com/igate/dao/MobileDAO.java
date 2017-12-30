package com.igate.dao;
import java.util.ArrayList;
import java.util.Collection;

import com.igate.dto.MobileDTO;
import com.igate.exception.InvalidDataException;



public interface MobileDAO
{
	public void addMobile();
	public void deleteMobile(int mobileId);
	public  ArrayList<MobileDTO>  getMobiles();
	public MobileDTO getMobileByPriceRange(int lowRange,int highRange);
	public void updateMobileByQty(int qty,int mobileId)throws InvalidDataException;	
	public int getMobileQty(int mobileId)throws InvalidDataException;	
	public ArrayList<Integer> getMobileIds()throws InvalidDataException;
}
