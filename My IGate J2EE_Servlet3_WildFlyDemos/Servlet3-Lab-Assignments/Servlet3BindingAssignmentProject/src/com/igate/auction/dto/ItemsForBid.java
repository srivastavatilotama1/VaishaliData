package com.igate.auction.dto;

public class ItemsForBid
{

	@Override
	public int hashCode() 
	{
		
		return itemId;
	}
	@Override
	public boolean equals(Object obj) {
		ItemsForBid tempItemForBid=(ItemsForBid)obj;
		if(this.itemId==tempItemForBid.itemId)
		{
			return true;
			
		}
		else
		{
			return false;
		}
		
	}

	private int itemId;
	private String itemName;
	private float itemPrice;
	private  String status;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ItemsForBid(int itemId, String itemName, float itemPrice,
			String status) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.status = status;
	}
	@Override
	public String toString() {
		return "ItemsForBid [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPrice=" + itemPrice + ", status=" + status + "]";
	}
	
	public ItemsForBid() {
		super();
		
	}
	
}
