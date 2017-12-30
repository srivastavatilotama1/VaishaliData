package com.igate.vai;
public class Employee
{
		int empId;
		String empName;
		float empSal;
		char gender;
		Date dateOfJoin;		
		static int  count;
		public Employee(int empId, String empName, float empSal, char gender,
				Date dateOfJoin) 
		{
			super();
			this.empId = empId;
			this.empName = empName;
			this.empSal = empSal;
			this.gender = gender;
			this.dateOfJoin = dateOfJoin;
			count++;
		}
		public String dispEmpInfo()
		{
			return "Employee [empId=" + empId + ", empName=" + empName
					+ ", empSal=" + empSal + ", gender=" + gender
					+ ", dateOfJoin=" + dateOfJoin.dispDate() + "]";
		}
		
		public float calcEmpGrossSal()
		{
			return empSal;
		}
		
		public static void  getCount()
		{
			 System.out.println("  Count Of Emp Is :"+count);
		}
		

}
