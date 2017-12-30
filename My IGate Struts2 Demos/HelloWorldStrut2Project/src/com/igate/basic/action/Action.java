package com.igate.basic.action;
public interface Action {
	   public static final String SUCCESS = "successLogin";
	   public static final String NONE = "none";
	   public static final String ERROR = "errorLogin";
	   public static final String INPUT = "input";
	   public static final String LOGIN = "login";
	   public static final String NOTEXISTS = "userNotExists";
	   public String execute() throws Exception;
	}