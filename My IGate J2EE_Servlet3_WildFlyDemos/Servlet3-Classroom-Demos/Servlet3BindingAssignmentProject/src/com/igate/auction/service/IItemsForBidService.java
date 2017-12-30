package com.igate.auction.service;
import java.util.ArrayList;
import com.igate.auction.dto.ItemsForBid;
import com.igate.auction.exception.BidException;
public interface IItemsForBidService 
{
	public ArrayList<ItemsForBid> getAllBidItems()throws BidException;

	public ItemsForBid getItemForBidById(int itemId)throws BidException;
	public int updateItemStatus(int itemId)
			throws BidException ;
}
