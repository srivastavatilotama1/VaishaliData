package com.igate.intro;

public class CurrencyConverterImpl implements CurrencyConverter
{
	
	private double exchangeRate;
	
	

	public CurrencyConverterImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getExchangeRate() 
	{
		System.out.println("getExchangeRate()");		
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) 
	{
		System.out.println("setExchangeRate()");		
		this.exchangeRate = exchangeRate;
	}

	public double dollarsToRupees(double dollars) 
	{
		System.out.println("dollarsToRupees()");		
		return dollars * exchangeRate;
	}
	
	public CurrencyConverterImpl(double exchangeRate)
	{
		System.out.println("CurrencyConverterImpl Constructor ()"+exchangeRate);
		this.exchangeRate = exchangeRate;
	}
};