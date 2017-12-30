package com.igate.demo.bean;
public class LanguageBean
{
	private String firstname;
	private String language;
	private  String comment;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getComment()	
	{
		if(language.equalsIgnoreCase("C"))
		{
			return "Procedure Language";
		}
		else if(language.equalsIgnoreCase("Java"))
		{
			return "Pure OOP Language For Web Application";			
		}
		else if(language.equalsIgnoreCase("C++"))
		{
			return "Preffered OOP Language FOR System Programming";
		}
		else if(language.equalsIgnoreCase("DotNet"))
		{
			return "Microsoft OOP Language for Web Application";			
		}
		else
		{
			return " Sorry No Comments";
		}
		
	}

	@Override
	public String toString() {
		return "LanguageBean [firstname=" + firstname + ", language="
				+ language + ", comment=" + comment + "]";
	}
	public LanguageBean()
	{
		super();
	}
	
	

}
