package com.cg.bean;

public class CurrencyConvertorImpl  implements
ICurrencyConvertor
{
	private int exchangeRate;
	private String countryName;
	@Override
	public String toString() {
		return "CurrencyConvertorImpl [exchangeRate=" + exchangeRate
				+ ", countryName=" + countryName + "]";
	}
	public int getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(int exchangeRate) 
	{
		this.exchangeRate = exchangeRate;
	}
	@Override
	public double dollerToRupees(double dollers) 
	{		
		return (exchangeRate*dollers);
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	@Override
	public int yenToRupees(int yen)
	{		
		return (exchangeRate*yen);
	}
	public CurrencyConvertorImpl(int exchangeRate) 
	{
		super();
		this.exchangeRate = exchangeRate;
	}
	public CurrencyConvertorImpl() 
	{
		super();		
	}
	public CurrencyConvertorImpl(int exchangeRate, 
			String countryName) {
		super();
		this.exchangeRate = exchangeRate;
		this.countryName = countryName;
	}

}
