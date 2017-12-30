package com.igate.vai;






import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.XMLLayout;

import bat.Batch;
import stu.Student;
public class TestStuApp 
{
    public static void main( String[] args )
    {
    	Logger mylogger=Logger.getLogger("TestStuApp.class");
        System.out.println( "Welcome To IGate Vaishali !  " );
		System.out.println("********************************************");
		System.out.println(calcAdd(8,67));
		System.out.println("********************************************");
		Batch javaBatch=new Batch();		
		javaBatch.setBatchId(666);
		javaBatch.setBatchFaculty(" Vaishali Srivastava  ");
		javaBatch.setBatchTime("   9.00 AM TO 5.00 P.M  ");		
		
		Student  stu1=new Student();
		stu1.setRollNo(111);;
		stu1.setStuName("Shrini");
		stu1.setTotalMarks(78);
		stu1.setStuBatchInfo(javaBatch);
		
		System.out.println("Student Id :"+stu1.getRollNo());
		System.out.println("Student Name :"+stu1.getStuName());
		System.out.println("Student Marks :"+stu1.getTotalMarks());
		System.out.println("Student Batch Info  :  "+stu1.getStuBatchInfo().getBatchId()+
				stu1.getStuBatchInfo().getBatchTime()+
				stu1.getStuBatchInfo().getBatchFaculty());
		XMLLayout xmllayout=new XMLLayout();

		try 
		{
			FileAppender fileappender=				new FileAppender(xmllayout,"igate.log",true);
			
			mylogger.addAppender(fileappender);
			mylogger.debug("This is Debug Message  :"+javaBatch);
			mylogger.info("This is log message ");
			mylogger.warn("This is warning message");
			mylogger.error("This is error level message");
			mylogger.fatal("This is fatal error message");
			System.out.println("This is my logging  programe");
			
		} 
		catch (Exception e) 
		{		
			System.out.println(" Arrray Exception : "+
					e.getMessage());
			mylogger.error(e.getMessage());
			e.printStackTrace();
			
		}


    }
	public  static String  calcAdd(int a,int b)
	{
		return ("Addition Of Number is "+(a+b));
	}
}
