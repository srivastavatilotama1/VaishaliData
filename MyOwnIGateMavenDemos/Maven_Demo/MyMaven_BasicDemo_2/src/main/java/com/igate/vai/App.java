package com.igate.vai;
import bat.Batch;
import stu.Student;
public class App 
{
    public static void main( String[] args )
    {
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
    }
	public  static String  calcAdd(int a,int b)
	{
		return ("Addition Of Number is "+(a+b));
	}
}
