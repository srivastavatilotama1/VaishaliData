package com.igate.basic.action;
import com.opensymphony.xwork2.ActionSupport;
 
public class URLTagAction extends ActionSupport{
 
	private String linkname;
	public String execute() {
		return SUCCESS;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
 
}