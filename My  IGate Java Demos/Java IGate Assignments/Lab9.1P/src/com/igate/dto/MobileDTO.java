package com.igate.dto;

public class MobileDTO
{
	 long mobileId ;                            
		String  mobileName;	
		double mobilePrice ;                                  
		int mobileQuantity   ;
		public long getMobileId() {
			return mobileId;
		}
		public void setMobileId(long mobileId) {
			this.mobileId = mobileId;
		}
		public String getMobileName() {
			return mobileName;
		}
		public void setMobileName(String mobileName) {
			this.mobileName = mobileName;
		}
		public double getMobilePrice() {
			return mobilePrice;
		}
		public void setMobilePrice(double mobilePrice) {
			this.mobilePrice = mobilePrice;
		}
		public int getMobileQuantity() {
			return mobileQuantity;
		}
		public void setMobileQuantity(int mobileQuantity) {
			this.mobileQuantity = mobileQuantity;
		}
		
		

}
