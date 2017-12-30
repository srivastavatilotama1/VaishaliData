package com.igate.dto;

public class Currency {
	
	String currencyValue;

	public String getCurrencyValue() {
		return currencyValue;
	}
	public void setCurrencyValue(String currencyValue) 
	{
		this.currencyValue = currencyValue;
	}
	public Currency(){}

	public Currency(String currencyValue)
	{
		this.currencyValue=currencyValue;
	}

}
