import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class EmployeeService
{
	public static void main(String args[])
	{
		EmployeeRepository eso=new EmployeeRepository();
		sumOfSalOfAllEmp(EmployeeRepository.getEmployees()); 
		getDeptWiseEmpList(EmployeeRepository.getEmployees()); 
		getSeniorEmp(EmployeeRepository.getEmployees());
		getManagerDetails(EmployeeRepository.getEmployees());	 
		getEmpDuration(EmployeeRepository.getEmployees());	
		getEmpWithoutDept(EmployeeRepository.getEmployees());
		getDeptWithoutEmp(EmployeeRepository.getEmployees(),EmployeeRepository.getDepartments());
		getDeptWithHighestEmpCount(EmployeeRepository.getEmployees(),EmployeeRepository.getDepartments());
		getEmpHireDetails(EmployeeRepository.getEmployees());
		//getEmpHireOnSpecificDay(EmployeeRepository.getEmployees());
		getEmpSalHikeDEtails(EmployeeRepository.getEmployees());
		getEmpWithoutManager(EmployeeRepository.getEmployees());
		//getManagerSubordinates(EmployeeRepository.getEmployees());
		sortEmpByEmpId(EmployeeRepository.getEmployees());
		sortEmpByDept(EmployeeRepository.getEmployees());
		sortEmpByName(EmployeeRepository.getEmployees());
		
	}
	
	private static void sortEmpByName(List<Employee> empList) 
	{
		System.out.println(" Sorted Emp According to First Name ");
		empList.stream().
			sorted(
						(employee1,employee2)->
						employee1.getFirstName().compareTo(employee2.getFirstName())
					).
				forEach(System.out::println);			
		
	}

	private static void sortEmpByDept(List<Employee> empList) 
	{
		System.out.println(" Sorted Emp According to Dept   Name");
		empList.stream().
		filter(employee->employee.getDepartment()!=null).
		sorted((employee1,employee2)->
					(employee1.getDepartment().getDepartmentName().
							compareTo(employee2.getDepartment().getDepartmentName()))
				).
				forEach(System.out::println);						
		
	}

	private static void sortEmpByEmpId(List<Employee> empList)
	{
		System.out.println(" Sorted Emp According to ID ");		
		empList.stream().
				sorted((employee1,employee2)->
							(employee1.getEmployeeId()-employee2.getEmployeeId())
						).
						forEach(System.out::println);		
	}

	private static void getManagerSubordinates(List<Employee> empList)
	{
		System.out.println("****Create a method to accept first name and last name");
		System.out.println("of manager to print name of all his/her subordinates.  ");
		System.out.println(" Enter Manager Name :");
		try(Scanner sc=new Scanner(System.in))
		{
			String mgrFName=sc.next();
			String mgrLName=sc.next();
		
		int mgrId = empList.stream().
				filter(e->e.getFirstName().equals(mgrFName) && e.getLastName().equals(mgrLName)).
				collect(Collectors.toList()).
				get(0).
				getEmployeeId();
		
		empList.stream().
		filter(employee->employee.getManagerId()!=null &&employee.getManagerId()==mgrId).
		forEach(System.out::println);
		}
		catch(Exception e){}
		
		
	  
		
	}

	private static void getEmpWithoutManager(List<Employee> empList)
	{
		System.out.println("*****List employee Without Manager***** ");
		empList.stream().
				filter(employee->employee.getManagerId()==null).
				forEach(employee->System.out.println(employee.getEmployeeId()+ " : " +
				  employee.getFirstName()));
				
	}

	private static void getEmpSalHikeDEtails(List<Employee> empList) 
	{
		System.out.println("*****List employee name, salary and salary increased by 15%.***** ");
		empList.stream()
					.map(employee->(employee.getFirstName())	+ "  :   "+
								employee.getSalary() + "  : Hike :  "+
							(employee.getSalary()+(15.00f/100.00f)*employee.getSalary())
						)
					.forEach(System.out::println);			
	}

	
	private static void getEmpHireOnSpecificDay(List<Employee> empList)
	{
		System.out.println("List employee name, hire date and day of week for "+
	"   employee started on Friday. "+
	"(Hint:  Accept the day name for e.g. FRIDAY and list all employees joined on Friday)");
		
		Scanner sc=new Scanner(System.in);
		System.out.println(" Enter Day ");
		String dayName=sc.next().toUpperCase();				
		empList.stream()
				.filter(employee->employee.getHireDate().getDayOfWeek().equals(DayOfWeek.valueOf(dayName)))
				.map(employee->(employee.getFirstName() )	+ "  :   "+
						(employee.getHireDate() )  + "  :   "+
						(employee.getHireDate().getDayOfWeek())								
					)
					.forEach(System.out::println);
	}

	
	private static void getEmpHireDetails(List<Employee> empList) 
	{
		System.out.println("***List employee name, hire date and day of week on which employee has started.**** ");
		
		empList.stream()
				.map(employee->(employee.getFirstName() )	+ "  :   "+
								(employee.getHireDate() )  + "  :   "+
								(employee.getHireDate().getDayOfWeek())								
					).
					
					forEach(System.out::println);			
	}	
	private static void getDeptWithHighestEmpCount(List<Employee> empList,List<Department> 
	deptList)
	{
		System.out.println("****Get All  Department With  Emp Count******");			
		
		Map<String, List<Employee>> employeeListByDept=
							empList.stream()
							.filter(e->e.getDepartment()!=null).
							collect
							(Collectors.groupingBy(employee->employee.getDepartment().getDepartmentName()));
		
		 employeeListByDept.forEach(
				(dName,eList)->System.out.println(dName+"  Has  "+eList.size() +" Size  "));
		 
		System.out.println("*****Get Department with Highest Emp Count*******************************");		
		
		int maxEmpsize = employeeListByDept.keySet()
											.stream()
									.map(deptName->employeeListByDept.get(deptName).size())
									.max(Integer::compare)
									.get();
		
						employeeListByDept.keySet().stream()
								.filter(deptName->employeeListByDept.get(deptName).size() == maxEmpsize)
								.forEach(System.out::println); 		
		
		System.out.println(" Dept With  Max Emp count  is  :  "+maxEmpsize);
		
		//for for each below is the conventional way
		List<String> deptNameList=employeeListByDept.keySet().stream()
										.filter(deptName->employeeListByDept.get(deptName).size() == maxEmpsize)
										.collect(Collectors.toList());
		for(String dept:deptNameList)
		{
			System.out.println(" Dept Name: "+dept);
		}
		
		
			
	}
	private static void getDeptWithoutEmp(List<Employee> empList,List<Department> deptList)	
	{
		System.out.println("****Get Department Without Employee******");
		
		for(Department tempDept:deptList)
		{			
				boolean empOpt=
					empList.stream().
					filter(employee->employee.getDepartment()!=null).
					filter(employee->employee.getDepartment().getDepartmentId()==tempDept.getDepartmentId()).
					findFirst().isPresent();					
				if(empOpt==false)
				{
					System.out.println(tempDept.getDepartmentName()  +" Department  do not have any  employee  ");
				}				
		}		
		System.out.println("**************************************************");
			
	}
	
	//Find departments with highest count of employees
	private static void getEmpWithoutDept(List<Employee> empList)	
	{
		System.out.println("****Find out employees without department******");
		List<Employee> empWithoutDeptList=
				empList.stream().
				filter(employee->employee.getDepartment()==null).
				collect(Collectors.toList());
		System.out.println(empWithoutDeptList);
		
	}
	public static void  sumOfSalOfAllEmp(List<Employee> empList) 
	{	
		System.out.println("***************Get Sum Of sal Of All Employee***************");
		double sumOfSalOfAllEmp=0.0;
		DoubleSummaryStatistics stats = empList.
				stream().mapToDouble((employee) -> employee.getSalary()).
				summaryStatistics();
		System.out.println(" Total Sal Is : "+stats.getSum());
	}

	public static void getDeptWiseEmpList(List<Employee> empList)
	{	
		System.out.println("***************Find Department Wise Emp List**************");
		Stream<Employee> newEmpList=empList.stream();		
		Stream<Employee> newEmpDeptList=newEmpList.filter(e->e.getDepartment()!=null);		
		Map<String, List<Employee>> employeeListByDept=
				newEmpDeptList.collect(
						Collectors.groupingBy(employee->employee.getDepartment().getDepartmentName()));
		employeeListByDept.forEach(
				(dName,eList)->System.out.println(dName+"  Has  "+eList.size() +" Size  ")
				);
	}
	public static void getSeniorEmp(List<Employee> empList)
	{		
		System.out.println("***************Find Senior Employee********************");
		LocalDate today = LocalDate.now();
		Stream nameExpListStream =empList.stream().
				map(employee->employee.getEmployeeId()+":"		
						+(Period.between(employee.getHireDate(),today ).getYears())
						);	
		String namesExpList=(String)nameExpListStream.collect(Collectors.joining(", "));
		System.out.println(namesExpList);
		Optional<Employee> newExpEmpList=
				empList.stream().max((e,e1)->(int)(
				Period.between(e.getHireDate(),today ).toTotalMonths()-
				Period.between(e1.getHireDate(),today ).toTotalMonths()));		
		System.out.println("Senior Most Emp Is : "+newExpEmpList.get());
	}
	public static void getManagerDetails(List<Employee> empList){
							
		System.out.println("*********Employee  And Their  Manager Details***************");
		for(Employee tempEmp:empList)
		{
			if(tempEmp.getManagerId()==null)
			{
				System.out.println(tempEmp.getEmployeeId() + ":"+tempEmp.getFirstName()+" :  No Manager");
			}
			else
			{
				Stream<Employee> empManagerListStream=	empList.stream().
						filter(e->e.getEmployeeId()==tempEmp.getManagerId());	
				Optional<Employee> empObj=empManagerListStream.findFirst();
				Employee mgr=empObj.get();
				System.out.println(tempEmp.getEmployeeId() + ":  Report To :"+tempEmp.getFirstName()+" :  "+mgr.getFirstName());
			}			
		}
	}
	public static void getEmpDuration(List<Employee> empList)
	{		
		System.out.println("*****List employee name and duration of their service in months and days*****");
		LocalDate today=LocalDate.now();
		
		List<String> empServiceDurationList=				
				empList.stream().
					map(employee->employee.getFirstName() +"  : "+
								  employee.getLastName() + "  : "	+
								  Period.between(employee.getHireDate(),today).getYears() + " Years :  "+
								  Period.between(employee.getHireDate(),today).getMonths() + " Months :  And  "+
								  Period.between(employee.getHireDate(),today).getDays() + " Days \n"						
							).
							collect(Collectors.toList());
		System.out.println(empServiceDurationList);
		
	}
}
