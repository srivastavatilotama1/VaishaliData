package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("currencyConObj1")
public class CurrencyConvertorImpl  implements ICurrencyConvertor
{	
	private int exchangeRate;	
	private String countryName;
	@Override
	public String toString() {
		return "CurrencyConvertorImpl [exchangeRate=" + exchangeRate
				+ ", countryName=" + countryName + "]";
	}
	
	@Override
	public int yenToRupees(int yen)
	{		
		return (exchangeRate*yen);
	}
	
	@Override
	public double dollerToRupees(double dollers) 
	{		
		return (exchangeRate*dollers);
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
	@Autowired
	public CurrencyConvertorImpl(@Value("68")int exchangeRate, 
			@Value("India")String countryName) 
	{
		super();
		this.exchangeRate = exchangeRate;
		this.countryName = countryName;
	}

}
