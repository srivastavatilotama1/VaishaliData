package com.igate.auction.service;

import java.util.ArrayList;

import com.igate.auction.dao.IItemsForBidDao;
import com.igate.auction.dao.ItemsForBidDaoImpl;
import com.igate.auction.dto.ItemsForBid;
import com.igate.auction.exception.BidException;

public class ItemsForBidServiceImpl  implements IItemsForBidService
{
IItemsForBidDao itemsForBidDao=new ItemsForBidDaoImpl();
	@Override
	public ArrayList<ItemsForBid> getAllBidItems() throws BidException 
	{
		
		return itemsForBidDao.getAllBidItems();
	}
	@Override
	public ItemsForBid getItemForBidById(int itemId) throws BidException 
	{
	
		return itemsForBidDao.getItemForBidById(itemId);
	}
	@Override
	public int updateItemStatus(int itemId)
			throws BidException {
		
		return itemsForBidDao.updateItemStatus(itemId);
	}

}
