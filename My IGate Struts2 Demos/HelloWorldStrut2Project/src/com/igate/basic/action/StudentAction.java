package com.igate.basic.action;

import com.igate.dto.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport 
implements ModelDriven 
{
	 private Student stu = new Student();
	 
	    public StudentAction() {
	    	System.out.println(" Student Action Constructor Invoked");
	    }
	    public Object getModel() {
	        return stu;
	    }
	    public Student getStu() {
	    	System.out.println(stu);
			return stu;
		}

		public void setStu(Student stu) {
			System.out.println(stu);
			this.stu = stu;
		}

		public String execute() {
			System.out.println(" Inexecute   "+stu);
	        return "getGradePage";
	    }

}
