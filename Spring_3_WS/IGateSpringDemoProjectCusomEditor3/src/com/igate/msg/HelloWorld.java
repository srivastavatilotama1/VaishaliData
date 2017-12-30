package com.igate.msg;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

public class HelloWorld 
{
	ResourceBundleMessageSource messageSource;
	String country;
	String lang;

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		System.out.println("  ...........country "+country);
		this.country = country;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	public void init()
	{
		System.out.println(" HelloWorldBean is going through init.");
	}

	public ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public void destroy()
	{
		System.out.println(" HelloWorld Bean will destroy now.");
	}

	public void sayHelloInAllLanguage()
	{
		Locale locale = new Locale(country,lang);
		String msg = messageSource.getMessage("welcome.message",null,locale);
		System.out.println(msg);
	}

}
