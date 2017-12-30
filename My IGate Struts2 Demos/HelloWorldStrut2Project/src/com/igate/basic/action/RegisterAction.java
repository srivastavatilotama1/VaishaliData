package com.igate.basic.action;
import java.util.ArrayList;

import com.igate.dao.IUserDao;
import com.igate.dao.UserDaoImpl;
import com.igate.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport 
{	
	private String userName;

	private String password;

	private String firstName;

	private String emailAddress;

	private int age;

	private String lastName;

	private long phoneNo;	

	private String gender;

	private String about;

	private String country;

	private ArrayList<Country> countryList;

	private String[] community;

	private ArrayList<String> communityList;

	private Boolean  mailingList;
	private  String[] hobbies;

	public String[] getHobbies() {
		return hobbies;
	}
	IUserDao userDao=new UserDaoImpl();
	private String dob;	

	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		System.out.println(" DOB:.............."+dob);
		this.dob = dob;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public void setAge(int age) {
		this.age = age;
			}
	
	public int getAge() {
		return age;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public  RegisterAction() {

		System.out.println("Register Action constructor.....");
		countryList = new ArrayList<Country>();
		countryList.add(new Country(1, "India"));
		countryList.add(new Country(2, "USA"));
		countryList.add(new Country(3, "France"));
		countryList.add(new Country(4, "China"));

		communityList = new ArrayList<String>();

		communityList.add("Java");
		communityList.add(".Net");
		communityList.add("SOA");
		communityList.add("Testing");
		communityList.add("Unix");

		community = new String[]{"Java"};

		hobbies=new String[]{"Reading","Singing","Listening Music"};;
		mailingList = true;
		
	}

	public String execute() {

		LoginDTO loginDTO=new LoginDTO();
		loginDTO.setUserName(userName);
		loginDTO.setPassword(password);
		loginDTO.setFirstName(firstName);
		loginDTO.setLastName(lastName);
		loginDTO.setPhoneNo(phoneNo);
		loginDTO.setDob(dob);
	

		int status=userDao.addUser(loginDTO);
		if(status==1)
		{
			System.out.println(" User Added in table successfully");
			return "registerSuccess";
		}
		else
		{
			return "registerFail";
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ArrayList<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(ArrayList<Country> countryList) {
		this.countryList = countryList;
	}

	public String[] getCommunity() {
		return community;
	}

	public void setCommunity(String[] community) {
		this.community = community;
	}

	public ArrayList<String> getCommunityList() {
		return communityList;
	}

	public void setCommunityList(ArrayList<String> communityList) {
		this.communityList = communityList;
	}

	public Boolean getMailingList() {
		return mailingList;
	}

	public void setMailingList(Boolean mailingList) {
		this.mailingList = mailingList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


}
